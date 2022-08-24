package kg.megacom.students1.repositiries;

import kg.megacom.students1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update students set title =?2 where id=?1", nativeQuery = true)
    void update(Long id, String title);
}
