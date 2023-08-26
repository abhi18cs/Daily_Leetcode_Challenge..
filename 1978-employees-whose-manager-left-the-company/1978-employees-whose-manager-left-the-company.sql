# Write your MySQL query statement below
select employee_id from Employees 
where manager_id not in 
(select employee_id from Employees)
and salary <30000
order by employee_id

# SELECT employee_id FROM Employees
# WHERE manager_id NOT IN (SELECT employee_id FROM Employees)
# AND salary < 30000
# ORDER BY employee_id;
