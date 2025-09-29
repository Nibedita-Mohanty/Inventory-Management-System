package service;

import Entity.Order;
import Entity.OrderItem;

import java.util.List;

public interface OrderService {
     Order createOrder(List<OrderItem> items);
     List<Order> getOrders();
     Order getOrderById(int ProductId);




    }
