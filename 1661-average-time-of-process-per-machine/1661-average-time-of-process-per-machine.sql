# select a1.machine_id,a1.timestamp,a2.timestamp
# from Activity a1 join Activity a2
# on a1.process_id=a2.process_id
# and a1.machine_id=a2.machine_id
# and a1.timestamp<a2.timestamp;

# output of above query

# | machine_id | timestamp | timestamp |
# | ---------- | --------- | --------- |
# | 0          | 0.712     | 1.52      |
# | 0          | 3.14      | 4.12      |
# | 1          | 0.55      | 1.55      |
# | 1          | 0.43      | 1.42      |
# | 2          | 4.1       | 4.512     |
# | 2          | 2.5       | 5         |      
      
      
select a1.machine_id
, ROUND(AVG(a2.timestamp - a1.timestamp),3) as processing_time
from Activity a1
join Activity a2
on a1.process_id=a2.process_id
and a1.machine_id=a2.machine_id
and a1.timestamp<a2.timestamp
group by a1.machine_id;

# | machine_id | processing_time |
# | ---------- | --------------- |
# | 0          | 0.894           |
# | 1          | 0.995           |
# | 2          | 1.456           |

