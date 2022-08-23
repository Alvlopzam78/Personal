-- TAREA 5 --

-- Sacamos cuántas películas tenemos en cada store
-- select store_id, count(i.film_id) as tot_film
--from store s join inventory i using (store_id)
--group by store_id;

-- Sabemos que un cilindro a lo más puede cargar 50 kg
-- Si cada película con su arnés pesa 500 gr, entonces cada cilindro tendrá 100 películas
-- Por cuestiones de seguridad, establezcamos que el máximo de peliculas por cilindro sea 90
-- Con esa información vamos a agregar al query anterior cuántos cilindros necesitamos por store
--with conteo as(
--	select store_id, count(i.film_id) as tot_film
--	from store s join inventory i using (store_id)
--	group by store_id	
--)
--select store_id, tot_film, ceil(tot_film/((50000/500)-10.00)) as num_cilindros
--from conteo;

-- Ahora vamos a calcular las medidas de cada cilindro 

-- Empecemos por la ALTURA
-- Ya obtuvimos que cada cilindro tendrá 90 películas 
-- Suponemos que vamos a acomodar las verticalmente y que apilaremos un máximo de 6 películas.
-- la alutra de cada película con su arnés será de 30 cm suponiendo que las medidas son dadas como altura x profundidad x ancho 
-- Como vamos a acomodar las películas verticalmente y apilar máximo 6, entonces la altura mínima sería 30 cm * 6 = 180 cm
-- Ahora, por seguridad, digamos que haya 1 centímetro entre cada película apliada para que sea más fácil para el robot encontrarla
-- Entonces la altura sería 187 cm

--with conteo as(
--	select store_id, count(i.film_id) as tot_film
--	from store s join inventory i using (store_id)
--	group by store_id	
--),
--cilindros as(
--	select store_id, tot_film, ceil(tot_film/((50000/500)-10.00)) as num_cilindros
--	from conteo
--)
--select store_id, tot_film, num_cilindros, 30 * 6 + 7 as altura_cilindro_cm 
--from cilindros;

-- Ahora calculamos el RADIO
-- Como las películas están acomodadas verticalmente y están acomodadas en pilas de 6 películas, entonces tenemos 15 pilas de 6 películas cada una
-- Por lo anterior, en el centro de la base del cilíndro queda un polígono de 15 lados
-- Para calcular el radio mínimo utilizamos argumentos geométricos
-- Sabemos que el radio del círculo será la hipotenusa del triángulo que se forma con los siguientes catetos:
-- a: profundidad del arnés + apotema del polígono del centro
-- b: la mitad del ancho del arnés que es 4 cm
-- Hacemos los cálculos:
--with cat1 as(
--	select 21+(8/(2*tan(0.20944))) as a
--)
--select sqrt(power(a,2) + power(4,2))
--from cat1;
-- El resultado anterior es aprox. 40 cm 
-- Ese es el radio mínimo 
-- Por seguridad, y para mayot facilidad para el robot, establezcamos el radio igual a 45 cm

--Ahora si, todo junto, tenemos lo siguiente:
with conteo as(
	select store_id, count(i.film_id) as tot_film
	from store s join inventory i using (store_id)
	group by store_id	
),
cilindros as(
	select store_id, ceil(tot_film/((50000/500)-10.00)) as num_cilindros
	from conteo
),
altura as(
	select store_id, 30 * 6 + 7 as altura_cilindro_cm 
	from cilindros
),
cat1 as(
	select store_id, 21+(8/(2*tan(0.20944))) as a
	from altura
)
select store_id, tot_film, num_cilindros, altura_cilindro_cm, round((sqrt(power(a,2) + power(4,2)))) + 5 as radio_cilindro_cm
from cat1 join altura using (store_id) join cilindros using (store_id) join conteo using (store_id);
