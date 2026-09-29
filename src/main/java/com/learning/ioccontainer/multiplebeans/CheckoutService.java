package com.learning.ioccontainer.multiplebeans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    private final PaymentGateway paymentGateway;

    public CheckoutService(@Qualifier("stripePaymentGateway") PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkout() {
        paymentGateway.pay();
    }
}
