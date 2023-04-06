select user_id ,count(distinct follower_id) as followers_count from followers group by user_id;

# SELECT user_id, COUNT(DISTINCT follower_id) AS followers_count
# FROM followers
# GROUP BY user_id
