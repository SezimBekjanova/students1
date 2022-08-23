package kg.megacom.students1.repositiries;

import kg.megacom.students1.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group,Long> {
}
