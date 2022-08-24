package kg.megacom.students1.repositiries;

import kg.megacom.students1.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update courses set price =?2 where id=?1", nativeQuery = true)
    void update(Long id, Double price);
}
