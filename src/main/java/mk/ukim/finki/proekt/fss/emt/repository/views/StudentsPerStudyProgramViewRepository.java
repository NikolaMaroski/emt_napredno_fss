package mk.ukim.finki.proekt.fss.emt.repository.views;

import mk.ukim.finki.proekt.fss.emt.model.views.StudentsPerStudyProgramView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentsPerStudyProgramViewRepository extends JpaRepository<StudentsPerStudyProgramView,Long> {
}
