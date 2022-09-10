package com.mp.os.api.service;

import com.mp.os.api.common.Payment;
import com.mp.os.api.common.TransactionRequest;
import com.mp.os.api.common.TransactionResponse;
import com.mp.os.api.entity.Order;
import com.mp.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_PAYMENT_API_URI;

    public TransactionResponse saveOrder(TransactionRequest request) {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //Rest call
        Payment paymentResponse = restTemplate.postForObject(ENDPOINT_PAYMENT_API_URI, payment, Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success") ? "Payment processing is success and order placed " : "There is failure in payment order added to cart...!!!";
        orderRepository.save(order);

        return new TransactionResponse(order,paymentResponse.getAmount(), paymentResponse.getTransactionId(),response);
    }

}
