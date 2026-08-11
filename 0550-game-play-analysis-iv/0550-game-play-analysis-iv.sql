# Write your MySQL query statement below
Select round(
    count(distinct player_id) / (select count(distinct player_id) from Activity)
, 2) as fraction
from Activity
Where (player_id, DATE_SUB(event_date, INTERVAL 1 DAY)) IN 
(SELECT player_id, MIN(event_date) as first_login
From Activity
Group By player_id)
