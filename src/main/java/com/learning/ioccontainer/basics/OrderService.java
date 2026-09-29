package com.learning.ioccontainer.basics;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        System.out.println(">>> OrderService object created");
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.pay();
    }
}
