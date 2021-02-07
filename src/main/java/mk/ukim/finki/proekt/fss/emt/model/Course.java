package mk.ukim.finki.proekt.fss.emt.model;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "course")
public class Course {

    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @ManyToOne
    private StudyProgram studyProgram;

}
