# Write your MySQL query statement below
Select Distinct employee_id, department_id
From Employee
Where employee_id IN (
    Select employee_id
    From Employee
    Group By employee_id
    Having Count(*) = 1
) or primary_flag = 'Y';