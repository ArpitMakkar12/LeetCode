# Write your MySQL query statement below
Select customer_number
from Orders
Group by customer_number
Order by Count(*) Desc
Limit 1;
