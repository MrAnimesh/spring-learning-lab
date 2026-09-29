package com.learning.ioccontainer.basics;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentService() {
        System.out.println(">>> PaymentService object created");
    }

    public void pay() {
        System.out.println("Payment completed");
    }

}
