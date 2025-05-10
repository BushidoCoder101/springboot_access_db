package com.northwind.repository;

import com.northwind.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties = "spring.jpa.hibernate.ddl-auto=create-drop")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    
    @Test
    public void testFindAllNative() {
        // Arrange: Create and save a sample product.
        Product sample = new Product(1, "Test Product", "10 Boxes", 100.0);
        productRepository.save(sample);
        
        // Act: Retrieve products using the native query.
        List<Product> products = productRepository.findAllNative();
        
        // Assert: Verify that the returned list has exactly one product with the expected values.
        assertNotNull(products, "The result should not be null");
        assertEquals(1, products.size(), "There should be exactly one product");
        
        Product result = products.get(0);
        assertEquals(1, result.getId());
        assertEquals("Test Product", result.getName());
        assertEquals("10 Boxes", result.getQuantityPerUnit());
        assertEquals(100.0, result.getUnitPrice());
    }
}
