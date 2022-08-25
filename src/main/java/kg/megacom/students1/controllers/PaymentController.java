package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.dto.PaymentDto;
import kg.megacom.students1.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/add")
    public Object createPayment(@RequestBody PaymentDto paymentDto){
        return paymentService.createPayment(paymentDto);
    }
    @PutMapping("/update")
    public Payment updatePayment(@RequestParam Long id, @RequestParam String status){
        return paymentService.update(id,status);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        paymentService.delete(id);
    }
    @PostMapping("/v2/add")
    public Object createPaymentV2(@RequestParam Long group_id,@RequestParam Long student_id,@RequestParam double summa ){
        return paymentService.createPaymentV2(group_id,student_id,summa);
    }

}
