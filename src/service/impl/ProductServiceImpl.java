package service.impl;

import Entity.Product;
import service.ProductService;
import Exception.ProductNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ProductServiceImpl implements ProductService {

    private static  HashMap<Integer,Product> inventory = new HashMap<>() ;


    @Override
    public Product addProduct(Product product) {
        if(product == null) {
            IllegalArgumentException e = new IllegalArgumentException("User provide invalid Product");
            throw e;
        }
        int productId = product.getProductId();
        inventory.put(productId, product);
         return product;
    }

    @Override
    public Product updateProduct(Product product) {
        // Check if product exists in inventory
        if ( product != null && inventory.containsKey(product.getProductId())){
            // Replace the old product with the new one
            inventory.put(product.getProductId(), product);
            return product;
        } else {
            throw new ProductNotFoundException("product id is not valid, plz provide a valid productId");
        }

    }
    @Override
    public String deleteProduct(int productId) {
        if (inventory.containsKey(productId)){
            inventory.remove(productId);
            return "product deleted";
        } else  {
            throw new ProductNotFoundException("product id is not valid, plz provide a valid productId");
        }
    }

    @Override
    public Product searchProductById(int productId) {
        if (!inventory.containsKey(productId)) {
                throw new ProductNotFoundException("product id is not valid, plz provide a valid productId");
            }
            Product product = inventory.get(productId);
            return product;
        }

    @Override
    public List<Product> getAllProduct() {
        //create arraylist obj
        //iterate the hashmap and fetch hashmap value(product) , add the product to list
        ArrayList<Product> productList = new ArrayList<>();
        Set<Integer> productIds = inventory.keySet();
        for (Integer productId : productIds){
            Product product = inventory.get(productId);
            productList.add(product);
        }
        return productList;

        //    return new ArrayList<>(inventory.values());
    }

    @Override
    public String lowStockAlert(int productId , int thresholdValue) {
        if (!inventory.containsKey(productId)){
            throw new ProductNotFoundException("Product id  is invalid");
        }
        Product product = inventory.get(productId);
        if (product.getStock() < thresholdValue){
            return "product stock is low";
        }
        return "stock is available";
    }
}
