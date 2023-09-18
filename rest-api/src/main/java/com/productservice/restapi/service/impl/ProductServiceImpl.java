package com.productservice.restapi.service.impl;

import com.productservice.restapi.exception.ResourceNotFoundException;
import com.productservice.restapi.model.Product;
import com.productservice.restapi.repository.ProductRepository;
import com.productservice.restapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Product", "Id", id));
    }

    @Override
    public Product updateProduct(Product product, String id) {

        Product existingproduct = productRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Product", "Id", id));
        if(product.getName()!=null){existingproduct.setName(product.getName());}
        if(product.getBrand()!=null){existingproduct.setBrand(product.getBrand());}
        if(product.getCurrency()!=null){existingproduct.setCurrency(product.getCurrency());}
        if(product.getDescription()!=null){existingproduct.setDescription(product.getDescription());}
        if(product.getPrice()!=0){existingproduct.setPrice(product.getPrice());}
        if(product.getQuantity()!=0){existingproduct.setQuantity(product.getQuantity());}


        productRepository.save(existingproduct);

        return existingproduct;
    }

    @Override
    public void deleteProduct(String id) {

        productRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product", "Id", id));

        productRepository.deleteById(id);
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProductsSQL(query);
        return products;
    }

    @Override
    public List<Product> searchProductsPrice(int number) {
        List<Product> products = productRepository.searchProductsByPrice(number);
        return products;
    }


}
