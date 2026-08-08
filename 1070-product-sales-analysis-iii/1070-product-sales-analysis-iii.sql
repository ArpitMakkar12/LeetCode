# Write your MySQL query statement below
Select s.product_id, 
    s.year as first_year,
    s.quantity,
    s.price
From Sales s
Join (Select product_id, Min(year) as first_year
    From Sales 
    Group By product_id) f
on s.product_id = f.product_id
and s.year = f.first_year;