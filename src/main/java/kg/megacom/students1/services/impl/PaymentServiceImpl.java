package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.PaymentMapper;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.dto.PaymentDto;
import kg.megacom.students1.repositiries.PaymentRepo;
import kg.megacom.students1.services.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentMapper paymentMapper;
    public PaymentServiceImpl(PaymentMapper paymentMapper, PaymentRepo paymentRepo) {
        this.paymentMapper = paymentMapper;
        this.paymentRepo = paymentRepo;
    }
    private final PaymentRepo paymentRepo;

    @Override
    public Payment createPayment(PaymentDto paymentDto) {
        Payment payment = paymentMapper.toEntity(paymentDto);
        paymentRepo.save(payment);
        return payment;
    }

    @Override
    public List<PaymentDto> findAll() {
        List<Payment> paymentList = paymentRepo.findAll();
        return paymentMapper.toDtoList(paymentList);
    }

}
