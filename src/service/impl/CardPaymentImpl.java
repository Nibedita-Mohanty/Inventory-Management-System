package service.impl;

import Entity.Order;
import Entity.Payment;
import service.PaymentService;

public class CardPaymentImpl implements PaymentService {
    public Payment  makePayment(Order orderId , double amount){
        Payment payment = new Payment("CARD" +System.currentTimeMillis() , orderId ,amount , "CARD");
        payment.setStatus("SUCCESS");
        return payment;

    }
}
