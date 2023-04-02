# Write your MySQL query statement belows
select users.user_id,
concat (upper(substr(users.name,1,1)),lower(substr(users.name,2))) as name 
from users
order by users.user_id;






# SELECT Users.user_id,
# CONCAT (UPPER(SUBSTR(Users.name,1,1)),LOWER(SUBSTR(Users.name,2))) AS name
# FROM Users
# ORDER BY
# Users.user_id ASC