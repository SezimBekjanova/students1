package kg.megacom.students1.services;

import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    Payment createPayment(PaymentDto paymentDto);
    List<PaymentDto> findAll();
    Payment update(Long id, String status);
    void delete(Long id);
}
