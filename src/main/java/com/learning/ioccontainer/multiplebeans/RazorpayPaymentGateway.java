package com.learning.ioccontainer.multiplebeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // default winner
public class RazorpayPaymentGateway implements PaymentGateway{
    @Override
    public void pay() {
        System.out.println("Payment using razorpay");
    }
}
