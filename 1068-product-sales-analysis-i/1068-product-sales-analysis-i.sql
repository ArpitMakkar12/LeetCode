# Write your MySQL query statement below
SELECT p1.product_name, s1.year, s1.price
FROM Sales s1
LEFT JOIN Product p1
ON s1.product_id = p1.product_id;