# Write your MySQL query statement below
Select p1.product_id,
    IFNULL(
    Round(
        SUM(p1.price * u1.units) / SUM(u1.units),2
    ),0) as average_price
from Prices p1
left join UnitsSold u1
on p1.product_id = u1.product_id
and u1.purchase_date >= p1.start_date
and u1.purchase_date <= p1.end_date
group by p1.product_id;