package mk.ukim.finki.proekt.fss.emt.jobs;

import mk.ukim.finki.proekt.fss.emt.service.StudentService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private StudentService studentService;

    public ScheduledTasks(StudentService studentService) {
        this.studentService = studentService;
    }

    @Scheduled(fixedRate = 5000)
    public void refreshMViews(){
        studentService.refreshMV();
    }
}
