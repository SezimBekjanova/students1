package kg.megacom.students1.repositiries;

import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update payments set status =?2 where id=?1", nativeQuery = true)
    void update(Long id, String status);
}
