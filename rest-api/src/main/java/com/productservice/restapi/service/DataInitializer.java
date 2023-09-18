package com.productservice.restapi.service;

import com.productservice.restapi.model.Product;
import com.productservice.restapi.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {


        private final ProductRepository productRepository;

        @Autowired
        public DataInitializer(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @PostConstruct
        public void initializeData() {

            List<Product> existingData = productRepository.findAll();
            if (existingData.isEmpty()) {
                Product product1 = new Product();
                product1.setBrand("Pringles");
                product1.setName("Potato chips");
                product1.setCurrency("$");
                product1.setPrice(3);
                product1.setQuantity(50);
                product1.setDescription("Potato and wheat-based stackable snack chips");
                productRepository.save(product1);

                Product product2 = new Product();
                product2.setBrand("Coca-Cola");
                product2.setName("Coke");
                product2.setCurrency("$");
                product2.setPrice(1);
                product2.setQuantity(50);
                product2.setDescription("A carbonated soft drink");
                productRepository.save(product2);

                Product product3 = new Product();
                product3.setBrand("Oreo");
                product3.setName("Cookie");
                product3.setCurrency("$");
                product3.setPrice(1.5);
                product3.setQuantity(50);
                product3.setDescription("Cookies sandwich a rich creme filling between the bold taste of two chocolate wafers");
                productRepository.save(product3);
            }
        }


}
