DROP MATERIALIZED VIEW public.students_per_faculty;

CREATE MATERIALIZED VIEW public.students_per_faculty
    TABLESPACE pg_default
AS
SELECT f.id AS faculty_id,
       f.name as faculty_name,
       count(s.id) AS num_students
FROM student s
         LEFT JOIN study_program sp ON sp.id = s.study_program_id
         LEFT JOIN faculty f ON f.id = sp.faculty_id
GROUP BY f.id
WITH DATA;
