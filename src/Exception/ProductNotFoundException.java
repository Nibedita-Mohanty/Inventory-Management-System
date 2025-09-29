package Exception;

    public class ProductNotFoundException extends RuntimeException{

        public ProductNotFoundException() {
            super("product not found");
        }
        public ProductNotFoundException( String msg){
            super(msg);

        }
    }

