package com.productservice.restapi.controller;

import com.productservice.restapi.model.Product;
import com.productservice.restapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PreAuthorize("hasRole('USER')")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;



    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    //Create new product
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id){
        return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product product){

        return new ResponseEntity<Product>(productService.updateProduct(product,id), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String id){
        productService.deleteProduct(id);

        return new ResponseEntity<String>("Product Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }

    @GetMapping("/searchprice")
    public ResponseEntity<List<Product>> searchProductsByPrice(@RequestParam("number") int number){

        return ResponseEntity.ok(productService.searchProductsPrice(number));
    }

}
