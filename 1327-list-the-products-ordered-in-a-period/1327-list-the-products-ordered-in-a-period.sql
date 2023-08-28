
# Write your MySQL query statement below
# select product_name, sum(unit) as unit from Orders as o left join Products as p
# on o.product_id = p.product_id where order_date between '2020-02-01' and '2020-02-29'
# group by o.product_id having sum(unit) >= 100

SELECT p.product_name, SUM(o.unit) AS unit
FROM Products p
LEFT JOIN Orders o
ON p.product_id = o.product_id
WHERE MONTH(order_date) = '02' AND YEAR(order_date) = '2020'
GROUP BY p.product_name
HAVING unit >= 100 
