# Write your MySQL query statement below
Select p1.firstName, p1.lastName, a1.city, a1.state
from Person p1
Left Join Address a1 On p1.personId = a1.personId;