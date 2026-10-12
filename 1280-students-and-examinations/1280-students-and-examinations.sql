# Write your MySQL query statement below
SELECT s1.student_id, s1.student_name, sub.subject_name,
COUNT(e1.subject_name) AS attended_exams
FROM Students s1
CROSS JOIN Subjects sub
LEFT JOIN Examinations e1
ON s1.student_id = e1.student_id AND sub.subject_name = e1.subject_name
GROUP BY s1.student_id, s1.student_name, sub.subject_name
ORDER BY s1.student_id, sub.subject_name;