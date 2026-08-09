# Write your MySQL query statement below
Select e2.employee_id, e2.name, 
    Count(e1.employee_id) as reports_count,
    Round(AVG(e1.age)) as average_age
From Employees e1 
Join Employees e2
on e1.reports_to = e2.employee_id
group by e2.employee_id, e2.name
order by e2.employee_id;