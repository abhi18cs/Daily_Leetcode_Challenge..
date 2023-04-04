# # Write your MySQL query statement below
# SELECT max(Salary) AS SecondHighestSalary
# FROM Employee
# WHERE Salary NOT IN (SELECT max(Salary) FROM Employee)

SELECT(SELECT distinct salary from employee order by salary desc limit 1,1) AS SecondHighestSalary;