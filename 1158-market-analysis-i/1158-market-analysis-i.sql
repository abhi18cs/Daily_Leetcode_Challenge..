# Write your MySQL query statement below
SELECT user_id AS buyer_id,join_date,COUNT(o.order_id) AS orders_in_2019
FROM Users u
LEFT JOIN Orders o ON u.user_id = o.buyer_id AND YEAR(order_date)='2019'
GROUP BY user_id
ORDER BY user_id

