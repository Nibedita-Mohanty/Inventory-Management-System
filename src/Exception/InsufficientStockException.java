package Exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(){
        super();
    }
    public InsufficientStockException(String msg){
        super(msg);
    }
}
