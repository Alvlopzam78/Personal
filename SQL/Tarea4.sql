-- TAREA 4 --

-- 1. ¿Cuál es el promedio, en formato human-readable, de tiempo entre cada pago por cliente?
with dif as (
	select customer_id, payment_date - lag(payment_date)over(partition by customer_id order by payment_date) as dif_pago
	from payment p
),
t as (
	select customer_id, avg(dif_pago) as promedio 
	from dif 
	group by customer_id 
)
select customer_id, concat(c.first_name, ' ', c.last_name) as nombre, concat(extract(day from promedio), ' ', 'dias',' ', extract(hour from promedio), ' ', 'horas') as promedio_pagos
from t join customer c using (customer_id);

/* El query anterior es la solución al problema utilizando la función lag que vimos en clase.
 * Sin embargo, como nota adicional, creo que hay una manera un poco más eficiente de solucionar la pregunta sin utilizar dos selects
 * A continuación adjunto la segunda opción:
with t as(
	select customer_id, (max(payment_date) - min(payment_date))/(count(customer_id)-1) as promedio
	from payment p
	group by customer_id
)
select customer_id, concat(c.first_name, ' ', c.last_name) as nombre, concat(extract(day from promedio), ' ', 'dias',' ', extract(hour from promedio), ' ', 'horas') as promedio_pagos
from t join customer c using (customer_id)
order by 1 asc; 
 */

-- 2. ¿Sigue una distribución normal?
-- Primero necesitamos la funcion histogram
CREATE OR REPLACE FUNCTION histogram(table_name_or_subquery text, column_name text)
RETURNS TABLE(bucket int, "range" numrange, freq bigint, bar text)
AS $func$
BEGIN
RETURN QUERY EXECUTE format('
  WITH
  source AS (
    SELECT * FROM %s
  ),
  min_max AS (
    SELECT min(%s) AS min, max(%s) AS max FROM source
  ),
  histogram AS (
    SELECT
      width_bucket(%s, min_max.min, min_max.max, 20) AS bucket,
      numrange(min(%s)::numeric, max(%s)::numeric, ''[]'') AS "range",
      count(%s) AS freq
    FROM source, min_max
    WHERE %s IS NOT NULL
    GROUP BY bucket
    ORDER BY bucket
  )
  SELECT
    bucket,
    "range",
    freq::bigint,
    repeat(''*'', (freq::float / (max(freq) over() + 1) * 15)::int) AS bar
  FROM histogram',
  table_name_or_subquery,
  column_name,
  column_name,
  column_name,
  column_name,
  column_name,
  column_name,
  column_name
  );
END
$func$ LANGUAGE plpgsql;

-- Ahora creamos una vista que guarde la tabla de los promedios entre pagos por cliente
create or replace view promedio_pagos as
	with dif as (
		select customer_id, payment_date - lag(payment_date)over(partition by customer_id order by payment_date) as dif_pago
		from payment p
	)
select customer_id, extract ('epoch' from avg(dif_pago)) as promedio 
from dif 
group by customer_id;

-- Finalmente creamos un histograma para poder concluir si sigue una distribución normal o no
select * from histogram('promedio_pagos', 'promedio');

/* Se puede observar en el histograma creado que la frecuencia se encuentra cargada a la izquierda del dominio.
 * Eso significa que la distribución no es normal. 
 * Además, es fácil ver que tiene dos máximos locales (en 2 y en 10), lo cual una distribución normal nunca cumple.
 */

-- 3. ¿Qué tanto difiere ese promedio del tiempo entre rentas por cliente?
-- Diferencias entre pagos (sacado de la pregunta 1)
with dif_pagos as (
	select customer_id, payment_date - lag(payment_date)over(partition by customer_id order by payment_date) as dif_pago
	from payment p
),
t as (
	select customer_id, avg(dif_pago) as prom_pago
	from dif_pagos 
	group by customer_id 
),
dif_rentas as (
	select customer_id, rental_date - lag(rental_date)over(partition by customer_id order by rental_date) as dif_renta
	from rental r 
),
r as (
	select customer_id, avg(dif_renta) as prom_renta
	from dif_rentas 
	group by customer_id 
),
info as (
	select customer_id, 
	concat(c.first_name, ' ', c.last_name) as nombre, 
	concat(extract(day from prom_pago), ' ', 'dias',' ', extract(hour from prom_pago), ' ', 'horas') as promedio_pagos,
	concat(extract(day from prom_renta), ' ', 'dias',' ', extract(hour from prom_renta), ' ', 'horas') as promedio_rentas
	from t join customer c using (customer_id) join r using (customer_id)
)
select customer_id, nombre, 
promedio_pagos,
promedio_rentas,
concat(extract(day from prom_pago - prom_renta), ' ', 'dias',' ', extract(hour from prom_pago - prom_renta), ' ', 'horas') as diferencia_promedios
from t join customer c using (customer_id) join r using (customer_id) join info using (customer_id);

/* Podemos observar que ambos promedios son muy similares pues la diferencia entre la gran mayoría de ellos es cero.
 * Sin embargo, hay algunos clientes (el 401 por ejemplo) que sí difieren un poco aunque en no más de un día.
 */ 

