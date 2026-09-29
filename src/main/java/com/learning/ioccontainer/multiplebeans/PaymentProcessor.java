package com.learning.ioccontainer.multiplebeans;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentProcessor {

    // Spring understands: List<PaymentGateway> -> As: Give me all beans implementing PaymentGateway
    private List<PaymentGateway> paymentGateways;
    public PaymentProcessor(List<PaymentGateway> gateways){
        this.paymentGateways = gateways;
    }

    public void listAllTheGateways(){
        paymentGateways.forEach((gateway) -> {
            System.out.println(gateway.getClass().getName());
        });
    }
}
