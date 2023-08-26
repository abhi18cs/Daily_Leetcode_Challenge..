# Write your MySQL query statement below
select
(select u.name from
(select
count(distinct movie_id) as cnt,user_id
from MovieRating
group by user_id) as a
inner join
Users u
on u.user_id = a.user_id
order by a.cnt desc , u.name
limit 1 ) as results
union all
select
(select m.title 
from
(select avg(rating) as rt,movie_id
from MovieRating
where created_at  between "2020-02-01" and "2020-02-29"
group by movie_id) as t
inner join Movies m
on m.movie_id = t.movie_id
order by t.rt desc,m.title
limit 1) as results
