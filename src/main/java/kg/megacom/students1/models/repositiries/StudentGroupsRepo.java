package kg.megacom.students1.models.repositiries;

import kg.megacom.students1.models.StudentGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGroupsRepo extends JpaRepository<StudentGroups,Long> {
}
