# Write your MySQL query statement below
Select customer_id 
From Customer
Group by customer_id 
Having COUNT(Distinct product_key) = (
    Select Count(product_key)
    From Product
)