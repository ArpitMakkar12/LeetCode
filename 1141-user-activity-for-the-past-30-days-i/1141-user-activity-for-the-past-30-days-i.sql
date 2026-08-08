# Write your MySQL query statement below
Select 
    activity_date as day,
    Count(distinct user_id) as active_users
From Activity
Where activity_date Between '2019-06-28' and '2019-07-27'
group by activity_date;