CREATE VIEW students_per_study_program AS

select sp.id as study_program_id, sp.name as study_program_name, count(s.id) as num_students
from study_program sp
         left join student s
                   on s.study_program_id = sp.id
group by s.id;
