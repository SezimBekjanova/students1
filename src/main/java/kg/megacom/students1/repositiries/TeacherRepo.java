package kg.megacom.students1.repositiries;

import kg.megacom.students1.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update teachers set name =?2 where id=?1", nativeQuery = true)
    void update(Long id, String name);

}
