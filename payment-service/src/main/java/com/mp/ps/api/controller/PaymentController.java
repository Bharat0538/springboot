package com.mp.ps.api.controller;

import com.mp.ps.api.entity.Payment;
import com.mp.ps.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        payment.setPaymentStatus(isPaymentProcessing());
        return paymentService.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment getPaymentHistory(@PathVariable("orderId") int orderId){
        return paymentService.getPaymentHistoryByOrderId(orderId);
    }

    public String isPaymentProcessing(){
        //api should be third party api call e.g. (paytm,paypal...)
        return new Random().nextBoolean()?"success":"failed";
    }
}
