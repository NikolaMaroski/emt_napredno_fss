package mk.ukim.finki.proekt.fss.emt.model;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


@Entity
@Data
@Table(name = "study_program")
public class StudyProgram {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    private Faculty faculty;

    @OneToMany(mappedBy = "studyProgram")
    private List<Student> students;

    @OneToMany(mappedBy = "studyProgram")
    private List<Course> courses;
}
