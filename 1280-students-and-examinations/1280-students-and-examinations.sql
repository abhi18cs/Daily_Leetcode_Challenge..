# First, join students on subjects

# select st.student_id, st.student_name, sb.subject_name
# from Students st
# join Subjects sb
# which gives you these results when run

# {"headers": ["student_id", "student_name", "subject_name"], 
#   "values":  [[1, "Alice", "Programming"], 
#                  [1, "Alice", "Physics"],
# 				 [1, "Alice", "Math"], 
# 				 [2, "Bob", "Programming"], 
# 				 [2, "Bob", "Physics"],
# 				 [2, "Bob", "Math"], 
# 				 [13, "John", "Programming"], 
# 				 [13, "John", "Physics"],
# 				 [13, "John", "Math"], 
# 				 [6, "Alex", "Programming"],
# 				 [6, "Alex", "Physics"], 
# 				 [6, "Alex", "Math"]]}
# step 2: now we have data given to us in this format we can do a left join on examinations table
# like this

# left join
# examinations e
# on e.student_id = st.student_id
# and e.subject_name = sb.subject_name
# now all we have to do is group it by our student_id and subject_name
# and then order it by or sort it by our student_id like this

# on e.student_id = st.student_id
# and e.subject_name = sb.subject_name
# group by st.student_id, sb.subject_name
# order by st.student_id
# add it all together


select st.student_id, st.student_name, sb.subject_name, count(e.subject_name) as attended_exams
from Students st
join Subjects sb
left join
examinations e
on e.student_id = st.student_id
and e.subject_name = sb.subject_name
group by st.student_id, sb.subject_name
order by st.student_id