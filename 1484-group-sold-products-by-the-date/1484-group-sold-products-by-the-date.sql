# Write your MySQL query statement below
select sell_date,
    count(distinct product) num_sold,
    group_concat(distinct product) products 
from activities 
group by sell_date
order by sell_date

# SELECT sell_date,
#     COUNT(DISTINCT product) num_sold,
#     GROUP_CONCAT(DISTINCT product) products
# FROM Activities
# GROUP BY sell_date
# ORDER BY sell_date