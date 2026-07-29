# Write your MySQL query statement below
Select W1.id 
from Weather W1
join Weather W2
on datediff(W1.recordDate, W2.recordDate) = 1
where W1.temperature > W2.temperature;