package service.impl;

import Entity.Order;
import Entity.OrderItem;
import Entity.Product;
import service.OrderService;
import Exception.OrderIdNotFoundException;
import Exception.InsufficientStockException;
import java.util.*;

public class OrderServiceImpl implements OrderService {
    private static HashMap<Integer, Order> OrderMap = new HashMap<>();
    private static int orderIdCounter = 1;

    @Override
    public Order createOrder(List<OrderItem> items) {
        double total = 0;
        for (OrderItem item : items) {
            Product product = item.getProduct();
            if (product.getStock() < item.getQuantity()) {
                throw new InsufficientStockException("Insufficient stock for " + product.getProductName());
            }
            total = total + item.getSubtotal();
            product.setStock(product.getStock() - item.getQuantity());
        }
        Order order = new Order(orderIdCounter++, new Date(), total, items);
        OrderMap.put(order.getOrderId(), order);
        return order;
    }


    @Override
    public List<Order> getOrders() {
        ArrayList<Order> orderList = new ArrayList<>();
        Set<Integer> orderIds = OrderMap.keySet();
        for (Integer orderId : orderIds) {
            Order order = OrderMap.get(orderId);
            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public Order getOrderById(int orderId) {
        if (!OrderMap.containsKey(orderId)) {
            throw new OrderIdNotFoundException("Order id is not valid, plz provide a valid OrderId");
        }
        Order order = OrderMap.get(orderId);
        return order;
    }
}

