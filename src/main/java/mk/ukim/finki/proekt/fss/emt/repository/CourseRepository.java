package mk.ukim.finki.proekt.fss.emt.repository;

import mk.ukim.finki.proekt.fss.emt.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
