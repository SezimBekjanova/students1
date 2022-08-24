package kg.megacom.students1.services;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.PaymentDto;
import kg.megacom.students1.models.enums.PaymentStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

public interface PaymentService {
    Payment createPayment(PaymentDto paymentDto);
    List<PaymentDto> findAll();
    Payment update(Long id, String status);
    void delete(Long id);
    ResponseEntity createPaymentV2(Long group_id, Long student_id, double summa );
}
