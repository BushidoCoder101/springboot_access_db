package com.northwind.service;

import com.northwind.model.Product;
import com.northwind.repository.ProductRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Synchronous method for comparison
    public List<Product> getAllProductsNative() {
        return productRepository.findAllNative();
    }

    // Asynchronous version of the method
    @Async("taskExecutor")
    public CompletableFuture<List<Product>> getAllProductsNativeAsync() {
        List<Product> products = productRepository.findAllNative();
        return CompletableFuture.completedFuture(products);
    }
}
