-- TAREA 3

-- Pregunta 1
-- ¿Cómo obtenemos todos los nombres y correos de nuestros clientes canadienses para una campaña?
select c3.country, concat(c.first_name, ' ', c.last_name), c.email  
from customer c join address a using (address_id)
join city c2 using (city_id)
join country c3 using (country_id)
group by c3.country, c.customer_id 
having country = 'Canada';

-- Pregunta 2
-- ¿Qué cliente ha rentado más de nuestra sección de adultos?
-- Es importante considerar en esta pregunta que la interpreté como qué cliente ha rentado una película de adultos más veces.  
select count(c.customer_id), concat(c.first_name, ' ', c.last_name) as customer_name
from rental r join inventory i using (inventory_id)
join film f using (film_id) join customer c using (customer_id)
group by f.rating, c.customer_id 
having f.rating = 'NC-17'
order by 1 desc
limit 2;
-- El limit lo truncamos en 2 porque hay dos clientes que han rentado el mismo número de películas

-- Pregunta 3
-- ¿Qué películas son las más rentadas en todas nuestras stores?
/*
 * La pregunta puede interpretarse de dos maneras:
 * Una, regresando la película más rentada de todas las sotres
 * Otra, regresando la película más rentada de cada store
 * El siguiente query regresa ambas respuestas apoyándome del rollup
 */

select distinct on (store_id) store_id, count(f.title), f.title  
from rental r join inventory i using (inventory_id)
join film f using (film_id)
group by rollup (f.title, store_id)
having f.title notnull 
order by 1, 2 desc; 

/*select distinct on (store_id) store_id as store, count(film_id), f.title  
 * from rental r join inventory i using (inventory_id)
 * join film f using (film_id)
 * group by film_id, store_id
 * order by 1,2 desc;
 * */

/*
 * select count(film_id), f.title  
 * from rental r join inventory i using (inventory_id)
 * join film f using (film_id)
 * group by film_id
 * order by 1 desc
 * limit 1;
*/

-- Pregunta 4
-- ¿Cuál es nuestro revenue por store?
-- Consideré revenue la suma de todos los montos de rentas que entraron a cada store por año
-- El query regresa el total del revenue por año de cada store, el total durante toda la vida de la store y el total de revenue de las dos stores.
-- Lo anterior fue apoyándome en el group by rollup
select i.store_id as store, sum(p.amount) as revenue, extract (year from p.payment_date) as year 
from payment p join rental r using (rental_id)
join inventory i using (inventory_id)
group by rollup (store_id, year);
