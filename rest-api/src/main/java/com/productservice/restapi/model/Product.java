package com.productservice.restapi.model;

import com.productservice.restapi.service.ProductService;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Data
@Table(name="products")
public class Product {
    @Id
    @UuidGenerator
    private String id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="brand", nullable = false)
    private String brand;
    @Column(name="currency", nullable = false)
    private String currency;
    @Column(name="price", nullable = false)
    private double price;
    @Column(name="quantity", nullable = false)
    private int quantity;
    @Column(name="description", nullable = false)
    private String description;

    public Product(){};

    public Product(String id, String name, String brand, String currency, double price, int quantity, String description) {
        super();
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.currency = currency;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
