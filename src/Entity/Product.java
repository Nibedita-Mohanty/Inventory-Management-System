package Entity;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private String productCategory;
    private int stock;

    public Product(){

    }
    public Product(int productId, String productName,double productPrice, String productCategory, int stock){
        this.productName = productName;
        this.productId = productId;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.stock = stock;
    }

    public Product( String productName,double productPrice, String productCategory, int stock){
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.stock = stock;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }
    public int getProductId(){
        return productId;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductCategory(String productCategory){
        this.productCategory = productCategory;
    }
    public String getProductCategory(){
        return productCategory;
    }
    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }
    public double getProductPrice(){
        return productPrice;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public int getStock(){
        return stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory='" + productCategory + '\'' +
                ", stock=" + stock +
                '}';
    }
}
