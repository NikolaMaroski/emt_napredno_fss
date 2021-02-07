package mk.ukim.finki.proekt.fss.emt.service.impl;

import mk.ukim.finki.proekt.fss.emt.model.Student;
import mk.ukim.finki.proekt.fss.emt.repository.StudentRepository;
import mk.ukim.finki.proekt.fss.emt.repository.views.StudentsPerFacultyViewRepository;
import mk.ukim.finki.proekt.fss.emt.service.StudentService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentsPerFacultyViewRepository studentsPerFacultyViewRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentsPerFacultyViewRepository studentsPerFacultyViewRepository,
                              ApplicationEventPublisher applicationEventPublisher) {
        this.studentRepository = studentRepository;
        this.studentsPerFacultyViewRepository = studentsPerFacultyViewRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createNewStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public void refreshMV() {
        studentsPerFacultyViewRepository.refreshMV();
    }
}
