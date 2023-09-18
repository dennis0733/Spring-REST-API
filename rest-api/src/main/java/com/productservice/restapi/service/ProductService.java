package com.productservice.restapi.service;

import com.productservice.restapi.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(String id);
    Product updateProduct(Product product, String id);

    void deleteProduct(String id);
    List<Product> searchProducts(String keyword);

    List<Product> searchProductsPrice(int number);



}
