package kg.megacom.students1.repositiries;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update lessons set group_id =?2 where id=?1", nativeQuery = true)
    void update(Long id, Long group);
}
