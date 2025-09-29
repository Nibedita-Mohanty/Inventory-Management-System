package service.impl;

import Entity.Order;
import Entity.Payment;
import service.PaymentService;

public class CashPaymentImpl implements PaymentService {
    public Payment makePayment(Order orderId , double amount){
        Payment payment = new Payment("CASH"+System.currentTimeMillis(), orderId , amount ,"CASH");
        payment.setStatus("SUCCESS");
        return payment;
    }
}
