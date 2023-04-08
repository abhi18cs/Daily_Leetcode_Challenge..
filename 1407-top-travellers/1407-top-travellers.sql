# Write your MySQL query statement below
SELECT  name, ifnull(SUM(Rides.distance),0)AS travelled_distance
FROM Users 
LEFT JOIN Rides
ON Users.id=Rides.user_id
GROUP By user_id
ORDER BY travelled_distance desc,name asc