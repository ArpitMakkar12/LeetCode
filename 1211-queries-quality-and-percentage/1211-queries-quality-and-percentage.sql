# Write your MySQL query statement below
Select query_name,
    Round(SUM(rating / position) / COUNT(query_name), 2) as quality,
    Round((SUM(rating < 3) / Count(query_name)) * 100, 2) as poor_query_percentage
from Queries
group by query_name