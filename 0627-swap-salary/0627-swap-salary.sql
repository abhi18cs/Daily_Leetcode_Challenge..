# Write your MySQL query statement below
# Update salary 
# set
# sex =case sex
# when 'f' then 'm' else 'f' end;

UPDATE Salary
    SET sex=(CASE WHEN sex='m' THEN 'f' ELSE 'm' END)