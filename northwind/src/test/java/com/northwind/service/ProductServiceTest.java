package com.northwind.service;

import com.northwind.model.Product;
import com.northwind.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    
    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetAllProductsNative() {
        // Synchronous test for comparison
        Product product = new Product(1, "Test Product", "10 Boxes", 99.99);
        List<Product> expectedProducts = Arrays.asList(product);
        when(productRepository.findAllNative()).thenReturn(expectedProducts);
        
        List<Product> actualProducts = productService.getAllProductsNative();
        assertEquals(expectedProducts, actualProducts);
        verify(productRepository, times(1)).findAllNative();
    }
    
    @Test
    public void testGetAllProductsNativeAsync() throws Exception {
        // Arrange: Stub the repository to return a sample product list.
        Product product = new Product(1, "Async Test Product", "15 Boxes", 150.0);
        List<Product> expectedProducts = Arrays.asList(product);
        when(productRepository.findAllNative()).thenReturn(expectedProducts);
        
        // Act: Call the asynchronous method.
        CompletableFuture<List<Product>> futureResult = productService.getAllProductsNativeAsync();
        // Wait for the async result to complete.
        List<Product> actualProducts = futureResult.get();
        
        // Assert: Verify that the returned list matches the expected value.
        assertEquals(expectedProducts, actualProducts);
        verify(productRepository, times(1)).findAllNative();
    }
}
