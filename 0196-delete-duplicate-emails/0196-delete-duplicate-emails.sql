# Write your MySQL query statement below
Delete p1
From Person p1 Inner join Person p2
on p1.email = p2.email and
p1.id > p2.id;
