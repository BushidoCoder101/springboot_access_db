package com.northwind.controller;

import com.northwind.model.Product;
import com.northwind.service.ProductService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ProductService productService;
    
    @Disabled
    @Test
    public void testGetAllProductsNative() throws Exception {
        // Test synchronous endpoint.
        Product product = new Product(1, "Test Product", "10 Boxes", 99.99);
        List<Product> products = Arrays.asList(product);
        when(productService.getAllProductsNative()).thenReturn(products);
        
        mockMvc.perform(get("/products/getAllProducts"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()").value(1))
               .andExpect(jsonPath("$[0].id").value(1))
               .andExpect(jsonPath("$[0].name").value("Test Product"));
    }
    
    @Disabled
    @Test
    public void testGetAllProductsNativeAsync() throws Exception {
        // Arrange: Stub service async method with sample product list.
        Product product = new Product(1, "Async Test Product", "15 Boxes", 150.0);
        List<Product> products = Arrays.asList(product);
        CompletableFuture<List<Product>> futureProducts = CompletableFuture.completedFuture(products);
        when(productService.getAllProductsNativeAsync()).thenReturn(futureProducts);

        // Act: Perform the asynchronous request.
        MvcResult mvcResult = mockMvc.perform(get("/products/async"))
                .andExpect(request().asyncStarted())
                .andReturn();
        
        // Dispatch and assert the result.
        mockMvc.perform(asyncDispatch(mvcResult))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()").value(1))
               .andExpect(jsonPath("$[0].id").value(1))
               .andExpect(jsonPath("$[0].name").value("Async Test Product"))
               .andExpect(jsonPath("$[0].quantityPerUnit").value("15 Boxes"))
               .andExpect(jsonPath("$[0].unitPrice").value(150.0));
    }
}
