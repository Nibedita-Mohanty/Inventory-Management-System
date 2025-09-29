package service;

import Entity.Order;
import Entity.Payment;

public interface PaymentService {
      Payment makePayment(Order orderId , double amount);

     // void makePayment(Order orderById);
}
