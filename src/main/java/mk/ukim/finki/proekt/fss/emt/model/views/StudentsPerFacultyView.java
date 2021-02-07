package mk.ukim.finki.proekt.fss.emt.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Subselect("SELECT * FROM students_per_faculty")
@Immutable
@Data
public class StudentsPerFacultyView {

    @Id
    @Column(name="faculty_id")
    private Long id;

    @Column(name="faculty_name")
    private String facultyName;

    @Column(name="num_students")
    private Integer numStudents;

}
