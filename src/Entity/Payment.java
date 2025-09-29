package Entity;

public class Payment {
    private String paymentId;
    private Order orderId;
    private double amount;
    private String method;
    private String status;

    public Payment(String paymentId , Order orderId , double amount , String method){
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;

    }
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrderId() {
        return orderId;
    }

//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
