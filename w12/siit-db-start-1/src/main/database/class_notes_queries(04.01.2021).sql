select *
from customers c ;

select *
from orders o ;

select *
from orders_products op ;

select *
from products p ;

select c.name, o.number, p.*
from customers c
join orders o on o.customer_id = c.id
join orders_products op on op.order_id = o.id
join products p on p.id  = op.product_id
where c.name like 'Leibniz Hans';

select * from customers where id in (1, 2, 3, 5);

select c.name, o."number", sum(op.quantity * p.weight)
from customers c
join orders o on o.customer_id = c.id
join orders_products op on op.order_id = o.id
join products p on p.id  = op.product_id
where c.name like 'Leibniz Hans'
group by c."name", o."number"
having sum(op.quantity * p.weight) > 1300;





