package mk.ukim.finki.proekt.fss.emt.model;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    private String index;
    private String name;

    @ManyToOne
    private StudyProgram studyProgram;

    @ManyToMany
    private List<Course> courses;


}
