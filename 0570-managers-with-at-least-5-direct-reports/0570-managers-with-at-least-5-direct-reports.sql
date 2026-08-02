# Write your MySQL query statement below
Select e1.name 
from Employee e1
join Employee e2
on e1.id = e2.managerId
group by e1.id
having COUNT(*) >= 5 
