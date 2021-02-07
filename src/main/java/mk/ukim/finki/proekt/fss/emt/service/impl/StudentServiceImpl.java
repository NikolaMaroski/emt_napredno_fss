package mk.ukim.finki.proekt.fss.emt.service.impl;

import mk.ukim.finki.proekt.fss.emt.model.Student;
import mk.ukim.finki.proekt.fss.emt.model.events.StudentCreatedEvent;
import mk.ukim.finki.proekt.fss.emt.repository.StudentRepository;
import mk.ukim.finki.proekt.fss.emt.repository.views.StudentsPerFacultyViewRepository;
import mk.ukim.finki.proekt.fss.emt.service.StudentService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentsPerFacultyViewRepository studentsPerFacultyViewRepository;
//    private final ApplicationEventPublisher applicationEventPublisher;
    private final ApplicationEventPublisher eventPublisher;

    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentsPerFacultyViewRepository studentsPerFacultyViewRepository,
                              ApplicationEventPublisher eventPublisher) {
        this.studentRepository = studentRepository;
        this.studentsPerFacultyViewRepository = studentsPerFacultyViewRepository;
        this.eventPublisher = eventPublisher;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createNewStudent(Student student) {
        studentRepository.save(student);
        eventPublisher.publishEvent(new StudentCreatedEvent(student, LocalDateTime.now()));
        return student;
    }

    @Override
    public void refreshMV() {
        studentsPerFacultyViewRepository.refreshMV();
    }
}
