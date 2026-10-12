# Write your MySQL query statement below
SELECT eu1.unique_id , e1.name
FROM Employees e1
LEFT JOIN EmployeeUNI eu1
ON e1.id = eu1.id;