package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.repositiries.PaymentRepo;
import kg.megacom.students1.services.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    public PaymentServiceImpl(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    private final PaymentRepo paymentRepo;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepo.save(payment);
    }
}
