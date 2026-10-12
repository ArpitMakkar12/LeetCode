# Write your MySQL query statement below
SELECT name, bonus
FROM Employee e1
LEFT JOIN Bonus b1
ON e1.empId = b1.empId
WHERE bonus IS NULL OR bonus < 1000;