package mk.ukim.finki.proekt.fss.emt.model.events;

import lombok.Getter;
import mk.ukim.finki.proekt.fss.emt.model.Student;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class StudentCreatedEvent extends ApplicationEvent {

    private LocalDateTime when;


    public StudentCreatedEvent(Object source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public StudentCreatedEvent(Student source, LocalDateTime when){
        super(source);
        this.when = when;
    }
}


