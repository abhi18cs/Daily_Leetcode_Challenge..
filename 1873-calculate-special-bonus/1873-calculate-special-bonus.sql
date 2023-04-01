# Write your MySQL query statement below
select employee_id,
CASE
    when name not like 'M%' and employee_id%2!=0
    then salary 
    else 0
End as bonus 
from employees
order by employee_id;
# SELECT employee_id,
# CASE 
#     WHEN name NOT LIKE 'M%' AND employee_id%2 <> 0
#     THEN salary
#     ELSE 0
# END AS bonus
# FROM Employees 
# ORDER BY employee_id;