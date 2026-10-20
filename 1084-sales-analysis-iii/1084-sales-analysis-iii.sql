# Write your MySQL query statement below
-- select product_id, product_name from Product
-- where product_id in (
--     select product_id from Sales
--     where sale_date between '2019-01-01' and '2019-03-31'
-- )
-- and product_id not in (
--     select product_id from Sales
--     where sale_date > '2019-03-31' or sale_date < '2019-01-01'
-- )

select p.product_id, p.product_name from Product p
join Sales s
on p.product_id = s.product_id
group by p.product_id
having min(s.sale_date) >= '2019-01-01'
and max(s.sale_date) <= '2019-03-31'