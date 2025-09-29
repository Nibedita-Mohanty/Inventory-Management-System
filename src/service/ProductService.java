package service;

import Entity.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product updateProduct(Product product);
    String deleteProduct(int productId);
    Product searchProductById(int productId);
    List<Product> getAllProduct();
    String lowStockAlert(int productId, int thresholdValue);
}




