-- TAREA 1

-- Parte 1
-- ejercicio 1
select * from suppliers s;
select s.contact_name 
from suppliers s
where s.contact_title = 'Sales Representative';

-- ejercicio 2
select s.contact_name 
from suppliers s
where s.contact_title != 'Marketing Manager';

-- ejercicio 3 
select * from orders o;

select o.order_id
from orders o join customers c using (customer_id)
where c.country != 'USA';

-- ejericio 4
select distinct p.product_id, p.product_name 
from categories c join products p using (category_id)
join order_details od using (product_id)
join orders o using (order_id)
where o.shipped_date is not null
and c.description = 'Cheeses';

-- ejercicio 5
select o.order_id 
from orders o
where o.ship_country = 'Belgium' or o.ship_country = 'France';

-- ejercicio 6
select o.order_id 
from orders o
where o.ship_country in ('Brazil', 'Venezuela', 'Mexico', 'Argentina');

-- ejercicio 7
select o.order_id 
from orders o
where o.ship_country not in ('Brazil', 'Venezuela', 'Mexico', 'Argentina');

-- ejercicio 8
select concat(e.first_name,' ', e.last_name) 
from employees e;

-- ejercicio 9
select sum(p.unit_price * p.units_in_stock)
from products p;

-- ejercicio 10
select c.country , count(*)
from customers c 
group by c.country;


-- Parte 2
-- ejercicio 1
select concat(e.first_name,' ', e.last_name), (current_date - e.birth_date)/365 as "Age"
from employees e;

-- ejercicio 2
--- opcion 1
select t.customer_id, t.contact_name, o2.order_id  
from 
(select c.customer_id, c.contact_name, max(o.order_date) as "order_date"  
from customers c join orders o using (customer_id)
group by c.customer_id) as t join orders o2 using (customer_id)
where o2.order_date = t.order_date;

--- opcion 2
select c.customer_id, c.contact_name, max(o.order_id) as "order_id"  
from customers c join orders o using (customer_id)
group by c.customer_id, c.contact_name;

-- ejercicio 3
select c.contact_title, count(*)
from customers c 
group by c.contact_title;

-- ejercicio 4
select c.category_name, count(*)
from categories c join products p using (category_id)
group by c.category_name;

-- ejercicio 5
-- Se da un reporte de los productos, no descontinuados, que es necesario recomprar porque hay menos unidades en stock de las unidades del reorder level
-- Además, se agrega cuántas órdenes hay de cada producto para hacer un estimado de la demanada de dicho producto.
select p.product_name, p.reorder_level, p.units_in_stock, count(o.order_id) as "num_orders"
from products p join order_details od using (product_id) join orders o using (order_id)
where p.reorder_level >= p.units_in_stock and p.discontinued = 0
group by p.product_name, p.reorder_level, p.units_in_stock
order by 4 desc;

-- ejercicio 6
--- opcion 1
select distinct concat (c.address, ' ', c.city, ' ', c.region, ' ', c.postal_code, ' ',c.country)  
from (select max(od.quantity) as "quantity"
from order_details od) as t join order_details od2 using (quantity)
join orders o2 using (order_id) join customers c using (customer_id)
where od2.quantity = t.quantity;

-- opcion 2
select distinct concat (c.address, ' ', c.city, ' ', c.region, ' ', c.postal_code, ' ',c.country)  
from orders o join order_details od using (order_id) join customers c using (customer_id)
where od.quantity = (select max(od2.quantity) from order_details od2);

-- ejercicio 7
-- Se copia la tabla customers en una tabla temoral y se agregan dos columnas: num_orders y current_prefernce.
-- La columna num orders nos indica cuántas órdenes ha hecho cada cliente.
-- En base al numero de órdenes se establece el criterio para determinar si los clientes son malos (deficient), buenos (preferent) o regulares (regular) y se actualiza la tabla
create type preference as enum('deficient', 'regular', 'preferent');
create temp table customers2 as (
select customer_id, c.company_name, c.contact_name, c.contact_title, c.address, c.city, c.region, c.postal_code, c.country, c.phone, c.fax, t.num_orders from customers c 
join (select c.customer_id, count(o.order_id) as "num_orders"
from customers c left outer join orders o using (customer_id)
group by c.customer_id) as t using (customer_id)
);

alter table customers2 add column current_preference preference;
update customers2 set current_preference = 'deficient' where num_orders < 10;
update customers2 set current_preference = 'regular' where num_orders between 10 and 20;
update customers2 set current_preference = 'preferent' where num_orders > 20;

select c.customer_id, c.contact_name, c.num_orders, current_preference from customers2 c;

-- ejercicio 8
-- Se seleccionan como fiestas navideñas solo los 25 de dicimebre porque es el día considerado oficial
select distinct e.employee_id, concat(e.first_name, ' ', e.last_name) as "Name" 
from orders o join employees e using (employee_id)
where extract(month from o.order_date) = 12 and extract(day from o.order_date) = 25;

-- ejercicio 9
select p.product_name 
from products p join order_details od using (product_id)
join orders o using (order_id)
where o.shipped_date is not null
and extract(month from o.shipped_date) = 12 and extract(day from o.shipped_date) = 25;

-- ejercicio 10
--- opcion 1
--- Interpretando que pide a qué país se va la orden más voluminosa 
select distinct o.ship_country 
from orders o join order_details od using (order_id)
where od.quantity = (select max(od2.quantity) from order_details od2);

--- opcion 2
--- Interpretando que pide a qué país se va la mayor cantidad de unidades de cualquier producto
select o.ship_country, sum(od.quantity) as "Cant"
from orders o join order_details od using (order_id)
group by o.ship_country
order by 2 desc limit 1;
