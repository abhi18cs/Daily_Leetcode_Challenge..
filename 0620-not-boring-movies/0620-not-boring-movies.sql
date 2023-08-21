# Write your MySQL query statement below
# select * from Cinema where (description!="boring") and (id%2=1) order by rating desc

# another solution
SELECT * FROM CINEMA 
WHERE mod(id,2)=1 AND DESCRIPTION not in("boring")
ORDER BY rating DESC;
