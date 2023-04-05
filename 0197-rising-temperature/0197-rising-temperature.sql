select t1.id 
from weather t1,weather t2 
where t1.temperature>t2.temperature 
and subdate(t1.recordDate,1)=t2.recordDate;