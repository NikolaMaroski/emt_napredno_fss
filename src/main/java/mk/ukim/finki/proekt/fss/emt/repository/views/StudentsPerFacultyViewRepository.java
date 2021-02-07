package mk.ukim.finki.proekt.fss.emt.repository.views;

import mk.ukim.finki.proekt.fss.emt.model.views.StudentsPerFacultyView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface StudentsPerFacultyViewRepository extends JpaRepository<StudentsPerFacultyView, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW students_per_faculty", nativeQuery = true)
    void refreshMV();

}
