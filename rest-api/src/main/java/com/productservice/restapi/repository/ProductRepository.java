package com.productservice.restapi.repository;

import com.productservice.restapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p WHERE " +
            "p.name LIKE CONCAT('%', :query, '%') " +
            "Or p.brand LIKE CONCAT('%', :query, '%')")
    List<Product> searchProducts(String query);

    @Query(value = "SELECT * FROM products p WHERE p.price <= :number order by price desc ", nativeQuery = true)
    List<Product> searchProductsByPrice(int number);

    @Query(value = "SELECT * FROM products p WHERE " +
            "p.name LIKE CONCAT('%', :query, '%') " +
            "Or p.brand LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    List <Product> searchProductsSQL(String query);
}
