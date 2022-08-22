package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Payment;
import kg.megacom.students1.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/add")
    public Object createPayment(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }

}
