package Exception;

public class OrderIdNotFoundException extends RuntimeException {
    public OrderIdNotFoundException(){
        super("Order id not found");
    }
    public OrderIdNotFoundException(String  msg){
        super(msg);
    }
}
