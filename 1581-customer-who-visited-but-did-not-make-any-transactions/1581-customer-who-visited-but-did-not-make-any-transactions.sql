# Write your MySQL query statement below
Select customer_id, Count(*) as count_no_trans
from Visits
left join Transactions
on Visits.visit_id = Transactions.visit_id
where Transactions.transaction_id is null
group by customer_id;