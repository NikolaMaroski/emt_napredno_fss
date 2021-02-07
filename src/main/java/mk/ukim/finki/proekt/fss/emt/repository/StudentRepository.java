package mk.ukim.finki.proekt.fss.emt.repository;

import mk.ukim.finki.proekt.fss.emt.model.Student;
import mk.ukim.finki.proekt.fss.emt.model.projections.StudentProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
    attributePaths = {"studyProgram","courses"})
    @Query("select s from Student s")
    List<Student> fetchAll();

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
    attributePaths = {"studyProgram"})
    @Query("select s from Student s")
    List<Student> loadAll();

    @Query("select s.index, s.name from Student s")
    List<StudentProjection> takeIndexAndNameByProjection();

    List<StudentProjection> findAllBy();

    StudentProjection findStudentByIndex(String index);
}
