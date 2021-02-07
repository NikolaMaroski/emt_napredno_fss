package mk.ukim.finki.proekt.fss.emt.xport.listeners;

import mk.ukim.finki.proekt.fss.emt.model.Student;
import mk.ukim.finki.proekt.fss.emt.model.events.StudentCreatedEvent;
import mk.ukim.finki.proekt.fss.emt.service.StudentService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventHandlers {

    private final StudentService studentService;

    public StudentEventHandlers(StudentService studentService) {
        this.studentService = studentService;
    }

    @EventListener
    public void onStudentCreated(StudentCreatedEvent event){
        System.out.println(((Student)event.getSource()).getName());
        this.studentService.refreshMV();
    }
}
