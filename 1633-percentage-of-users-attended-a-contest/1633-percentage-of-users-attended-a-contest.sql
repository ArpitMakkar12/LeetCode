# Write your MySQL query statement below
Select contest_id,
    Round(
        (COUNT(distinct user_id))* 100 / (Select COUNT(user_id) from Users),2
    ) as percentage
from Register
group by contest_id
order by percentage DESC, contest_id;