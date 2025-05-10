package com.northwind.controller;

import com.northwind.model.Product;
import com.northwind.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Synchronous endpoint
    @GetMapping({"/getAllProducts", "/allProducts", "/all"})
    public List<Product> getAllProductsNative() {
        return productService.getAllProductsNative();
    }

    // Asynchronous endpoint
    @GetMapping("/async")
    public CompletableFuture<ResponseEntity<List<Product>>> getAllProductsNativeAsync() {
        return productService.getAllProductsNativeAsync()
                             .thenApply(ResponseEntity::ok);
    }
}
