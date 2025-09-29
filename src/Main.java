import Entity.Order;
import Entity.OrderItem;
import Entity.Payment;
import Entity.Product;
import org.w3c.dom.ls.LSOutput;
import service.OrderService;
import service.PaymentService;
import service.ProductService;
import service.impl.*;
import Exception.ProductNotFoundException;
import Exception.OrderIdNotFoundException;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final ProductService inventoryService = new ProductServiceImpl();
    public static final OrderService orderService = new OrderServiceImpl();

    public static void main(String[] args) {
        Product product1 = new Product(1,"MI-11X",20000.0,"SmartPhone", 10);
        Product product2 = new Product(2,"JBL-12X",45000.0,"MusicBox", 10);
        Product product3 = new Product(3,"LG-14X",120000.0,"TV", 15);
        Product product4 = new Product(4,"Sony-23X",270000.0,"WashingMachine", 10);
        Product product5 = new Product(5,"Samsung-45X",89000.0,"Fridge", 10);
        try {
            Main.inventoryService.addProduct(product1);
            inventoryService.addProduct(product2);
            inventoryService.addProduct(product3);
            inventoryService.addProduct(product4);
            inventoryService.addProduct(product5);
//        System.out.println("--------------------------viewAllProduct-------------------------");
//        List<Product> allProduct = inventoryService.getAllProduct();
//        for (Product product : allProduct){
//            System.out.println(product);
//        }
        System.out.println("----------------------update product--------------------------------------------");
            product2.setProductCategory("Fridge");
            product2.setProductId(9);
            inventoryService.updateProduct(product2);
            System.out.println(inventoryService.searchProductById(product2.getProductId()));

        System.out.println("----------------------------Delete Product----------------------------------------------");
        String msg = inventoryService.deleteProduct(product2.getProductId());
        System.out.println(msg);
        System.out.println(inventoryService.searchProductById(product2.getProductId()));
        System.out.println("----------------------------view all product--------------------------------------------");
        System.out.println(inventoryService.getAllProduct());
        System.out.println("----------------------------------");
//        product3.setStock(3);
        inventoryService.updateProduct(product3);
        System.out.println(inventoryService.searchProductById(product3.getProductId()));
        System.out.println(inventoryService.lowStockAlert(product3.getProductId(), 4));
        System.out.println("---------------------------------------------------------------------------------------");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (ProductNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }




        OrderItem orderItem1 = new OrderItem(product4,2);
        OrderItem orderItem2 = new OrderItem(product3,3);
//        List<OrderItem> orderItemList = new ArrayList<>();
//        orderItemList.add(orderItem1);
//        orderItemList.add(orderItem2);
        Order order1 = orderService.createOrder(List.of(orderItem1, orderItem2));
        Order order2 = orderService.createOrder(List.of(orderItem1, orderItem2));

//        System.out.println("Newly created order is : ");
//        System.out.println(order);
//        List<OrderItem> orderItems = order.getOrderItems();
//        OrderItem orderItem = orderItems.get(0);
//        Product product = orderItem.getProduct();
//        System.out.println(product.getProductName());
//        for (OrderItem orderItem : orderItems){
//            System.out.println(orderItem.getProduct().getProductName());  //method chaining
 //       }
       List<Order> orders = orderService.getOrders();
//        System.out.println(orders);
        for (Order order : orders){
            System.out.println(order);
        }

//        System.out.println("---------------------------------------------------------------------------");
        try {
            Order fetchOrder = orderService.getOrderById(order1.getOrderId());
            System.out.println(fetchOrder);
        }catch (OrderIdNotFoundException e){
            System.out.println(e.getMessage());
        }

//        System.out.println("-------------------------------------------------------------------");

//        //Payment payment1 = paymentService1.makePayment(order1.getOrderId(), order1.getTotalAmount());

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Choose your payment method (CARD/CASH): " );
//        String method = sc.nextLine();

//        PaymentService paymentService;
//        if (method.equalsIgnoreCase("CARD")){
//            paymentService = new CardPaymentImpl();
//        }else{
//            paymentService = new CashPaymentImpl();
//        }

//        Payment payment = paymentService.makePayment(order1, order1.getTotalAmount());
//        System.out.println(payment);
//        System.out.println("payment done using " +payment.getMethod() +" Status : " +payment.getStatus());


    }






}