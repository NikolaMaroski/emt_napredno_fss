package mk.ukim.finki.proekt.fss.emt.repository;

import mk.ukim.finki.proekt.fss.emt.model.Course;
import mk.ukim.finki.proekt.fss.emt.model.Faculty;
import mk.ukim.finki.proekt.fss.emt.model.Student;
import mk.ukim.finki.proekt.fss.emt.model.StudyProgram;
import mk.ukim.finki.proekt.fss.emt.model.exception.StudentNotFoundException;
import mk.ukim.finki.proekt.fss.emt.model.projections.StudentProjection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    private List<Student> studentList;
    private List<Course> courseList;
    private List<Faculty> facultyList;
    private List<StudyProgram> studyPrograms;

    private Faculty f1,f2;
    private Course c1,c2,c3;
    private StudyProgram sp1,sp2,sp3;
    private Student s1,s2,s3;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudyProgramRepository studyProgramRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Before
    public void init() {
        if (facultyRepository.findAll().size()!=0) {
            return;
        }
        f1 = new Faculty();
        f1.setId(1L);
        f1.setName("FINKI");

        f2 = new Faculty();
        f2.setId(2L);
        f2.setName("FZF");

        facultyRepository.save(f1);
        facultyRepository.save(f2);

        sp1 = new StudyProgram();
        sp1.setId(1L);
        sp1.setName("PIT");
        sp1.setFaculty(f1);

        sp2 = new StudyProgram();
        sp2.setId(2L);
        sp2.setName("KNI");
        sp2.setFaculty(f1);

        sp3 = new StudyProgram();
        sp3.setId(3L);
        sp3.setName("Istorija");
        sp1.setFaculty(f2);

        studyProgramRepository.save(sp1);
        studyProgramRepository.save(sp2);
        studyProgramRepository.save(sp3);

        c1 = new Course();
        c1.setId(1L);
        c1.setStudyProgram(sp1);
        c1.setName("VP");

        c2 = new Course();
        c2.setId(2L);
        c2.setStudyProgram(sp2);
        c2.setName("EMT");

        c3 = new Course();
        c3.setId(3L);
        c3.setStudyProgram(sp3);
        c3.setName("Etika");

        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);


        s1 = new Student();
        s1.setIndex("111111");
        s1.setName("Petko");
        s1.setCourses(Arrays.asList((new Course[]{c1, c2})));
        s1.setStudyProgram(sp1);

        s2 = new Student();
        s2.setIndex("122222");
        s2.setName("Petar");
        s2.setCourses(Arrays.asList(new Course[]{c1, c2}));
        s2.setStudyProgram(sp2);

        s3 = new Student();
        s3.setIndex("133333");
        s3.setName("Milan");
        s3.setCourses(Arrays.asList(new Course[]{c3}));
        s3.setStudyProgram(sp3);

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
    }

    @Test
    public void testFindAll(){
        List<Student> students = studentRepository.findAll();
        Assert.assertEquals(3L, students.size());
    }

    @Test
    public void testFindOne(){
        String studentIndex = "111111";
        Student student =  studentRepository.findById(studentIndex).orElseThrow(StudentNotFoundException::new);
        Assert.assertEquals(studentIndex, student.getIndex());
    }

    @Test
    public void testFetchAll(){
        List<Student> students = studentRepository.fetchAll();
        Assert.assertEquals(3L, students.size());
    }

    @Test
    public void testLoadAll(){
        List<Student> students = studentRepository.loadAll();
        Assert.assertEquals(3L, students.size());
    }

    @Test
    public void testProjectIndexAndName(){
        StudentProjection studentProjection = studentRepository.findStudentByIndex("111111");
        Assert.assertEquals("111111", studentProjection.getIndex());
    }
}
