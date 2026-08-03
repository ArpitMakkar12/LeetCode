# Write your MySQL query statement below
Select p1.project_id,
    Round(
        SUM(e1.experience_years) / COUNT(e1.experience_years),2
    ) as average_years
from Project p1
left join Employee e1
on p1.employee_id = e1.employee_id
group by p1.project_id;