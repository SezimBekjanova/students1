package kg.megacom.students1.repositiries;

import kg.megacom.students1.models.StudentGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface StudentGroupsRepo extends JpaRepository<StudentGroups,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update student_groups set end_date =?2 where id=?1", nativeQuery = true)
    void update(Long id, Date end_date);
}
