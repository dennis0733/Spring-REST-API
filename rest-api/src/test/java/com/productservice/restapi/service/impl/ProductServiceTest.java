package com.productservice.restapi.service.impl;

import com.productservice.restapi.model.Product;
import com.productservice.restapi.repository.ProductRepository;
import com.productservice.restapi.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest {

    private ProductServiceImpl productService;
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        productRepository = Mockito.mock(ProductRepository.class);

        productService = new ProductServiceImpl(productRepository);


    }

    @Test
    public void whenAProductSavedAndAllProductsCalledWithValidRequestItShouldReturnValidProductsList(){
        Product product = new Product();
        product.setBrand("Test");
        product.setName("Test Product");
        product.setCurrency("$");
        product.setPrice(1);
        product.setQuantity(10);
        product.setDescription("Test Desc");
        List<Product> products = new ArrayList<>();
        products.add(product);

        Mockito.when(productService.getAllProducts()).thenReturn(products);
        Mockito.when(productRepository.save(product)).thenReturn(product);

        List <Product> result = productService.getAllProducts();

        Assert.assertEquals(result,products);

    }

    @Test
    public void whenAProductSearchedWithKeywordItShouldReturnValidProduct(){
        Product product = new Product();
        product.setId("0");
        product.setBrand("Test");
        product.setName("Test Product");
        product.setCurrency("$");
        product.setPrice(1);
        product.setQuantity(10);
        product.setDescription("Test Desc");
        List<Product> products = new ArrayList<>();
        products.add(product);

        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(productService.getAllProducts()).thenReturn(products);
        productRepository.save(product);

        Mockito.when(productService.searchProducts("Test")).thenReturn(products);

         List <Product> result = productService.searchProducts("Test");



        Assert.assertEquals(result,products);
    }

    @Test
    public void whenAProductDeletedItShouldReturnNullList(){
        Product product = new Product();
        product.setId("0");
        product.setBrand("Test");
        product.setName("Test Product");
        product.setCurrency("$");
        product.setPrice(1);
        product.setQuantity(10);
        product.setDescription("Test Desc");
        List<Product> products = new ArrayList<>();


        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(productService.getAllProducts()).thenReturn(products);

        productRepository.save(product);

        Mockito.when(productService.searchProducts("Test")).thenReturn(products);
        Mockito.when(productService.getAllProducts()).thenReturn(products);
        List<Product> result = productService.getAllProducts();



        Assert.assertEquals(result,products);
    }



}