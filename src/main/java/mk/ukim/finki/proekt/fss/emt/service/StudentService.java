package mk.ukim.finki.proekt.fss.emt.service;

import mk.ukim.finki.proekt.fss.emt.model.Student;
import java.util.*;

public interface StudentService {
    List<Student> getAllStudents();
    Student createNewStudent(Student student);
    void refreshMV();
}
