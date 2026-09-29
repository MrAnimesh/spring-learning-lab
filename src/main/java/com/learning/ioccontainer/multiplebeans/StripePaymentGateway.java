package com.learning.ioccontainer.multiplebeans;

import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway{
    @Override
    public void pay() {
        System.out.println("Payment using Stripe");
    }
}
