# Write your MySQL query statement below
select distinct num as ConsecutiveNums from Logs
WHERE (Id + 1, Num) in (select * from Logs) and (Id + 2, Num) in (select * from Logs)
