package mk.ukim.finki.proekt.fss.emt.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

@Entity
@Data
@Table(name = "faculty")
public class Faculty {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "faculty")
    private List<StudyProgram> studyPrograms;
}
