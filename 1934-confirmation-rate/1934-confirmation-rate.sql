# Write your MySQL query statement below
Select s1.user_id,
    Round(
    IFNULL(Sum(c1.action = "confirmed") / Count(c1.action),0),2) as confirmation_rate
from Signups s1
left join Confirmations c1
on s1.user_id = c1.user_id
group by s1.user_id