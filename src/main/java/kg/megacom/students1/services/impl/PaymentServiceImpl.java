package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.PaymentMapper;
import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.PaymentDto;
import kg.megacom.students1.models.enums.PaymentStatus;
import kg.megacom.students1.repositiries.CourseRepo;
import kg.megacom.students1.repositiries.GroupRepo;
import kg.megacom.students1.repositiries.PaymentRepo;
import kg.megacom.students1.repositiries.StudentRepo;
import kg.megacom.students1.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentMapper paymentMapper;
    private final PaymentRepo paymentRepo;
    private final StudentRepo studentRepo;
    private final GroupRepo groupRepo;
    private final CourseRepo courseRepo;
    public PaymentServiceImpl(PaymentMapper paymentMapper, PaymentRepo paymentRepo, StudentRepo studentRepo, GroupRepo groupRepo, CourseRepo courseRepo) {
        this.paymentMapper = paymentMapper;
        this.paymentRepo = paymentRepo;
        this.studentRepo = studentRepo;

        this.groupRepo = groupRepo;
        this.courseRepo = courseRepo;
    }
    @Override
    public Payment createPayment(PaymentDto paymentDto) {
        Payment payment = paymentMapper.toEntity(paymentDto);
        paymentRepo.save(payment);
        return paymentRepo.findById(payment.getId()).get();
    }

    @Override
    public List<PaymentDto> findAll() {
        List<Payment> paymentList = paymentRepo.findAll();
        return paymentMapper.toDtoList(paymentList);
    }

    @Override
    public Payment update(Long id, String status) {
        paymentRepo.update(id, status);
        return paymentRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        paymentRepo.delete(paymentRepo.findById(id).get());
    }

    @Override
    public ResponseEntity createPaymentV2(Long group_id, Long student_id, double summa) {
        Student student = studentRepo.findById(student_id).get();
        if(student.isDeleted()){
            return ResponseEntity.ok("?????????????? ?????? ????????????");
        }
        if(Objects.isNull(student)){
            return  ResponseEntity.ok("?????? ???????????? ????????????????");
        }
        Payment payment = new Payment();
        payment.setDate_payments(new Date());
        payment.setStudent(studentRepo.findById(student_id).get());
        payment.setGroup(groupRepo.findById(group_id).get());
        payment.setSumma(summa);
        Group group = groupRepo.findById(group_id).get();
        if(Objects.isNull(group)){
            return  ResponseEntity.ok("?????? ?????????? ????????????");
        }
        double result = group.getCourse().getPrice()-summa;
        payment.setRemainder(result);
        if(result>=0){
            payment.setStatus(PaymentStatus.PAID);
        }if(summa==0){
            payment.setStatus(PaymentStatus.UNPAID);
        }if(result<0){
            payment.setRemainder(0);
            payment.setStatus(PaymentStatus.REMAINDER);
        }

        return ResponseEntity.ok(paymentRepo.save(payment));
    }

}
