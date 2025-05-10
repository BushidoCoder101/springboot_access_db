package com.northwind.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testNoArgsConstructor() {
        // Instantiate using the no-argument constructor
        Product product = new Product();

        // By default, all object fields should be null
        assertNull(product.getId(), "ID should be null");
        assertNull(product.getName(), "Name should be null");
        assertNull(product.getQuantityPerUnit(), "QuantityPerUnit should be null");
        assertNull(product.getUnitPrice(), "UnitPrice should be null");
    }

    @Test
    public void testAllArgsConstructor() {
        // Instantiate using the all-arguments constructor
        Product product = new Product(1, "TEST PRODUCT", "10 BOXES", 99.99);

        // Verify that getters return the expected values
        assertEquals(1, product.getId());
        assertEquals("TEST PRODUCT", product.getName());
        assertEquals("10 BOXES", product.getQuantityPerUnit());
        assertEquals(99.99, product.getUnitPrice());
    }

    @Test
    public void testSettersAndGetters() {
        // Create a product instance and then set values
        Product product = new Product();
        product.setId(2);
        product.setName("ANOTHER PRODUCT");
        product.setQuantityPerUnit("5 UNITS");
        product.setUnitPrice(49.99);

        // Verify that getters return the values we just set
        assertEquals(2, product.getId());
        assertEquals("ANOTHER PRODUCT", product.getName());
        assertEquals("5 UNITS", product.getQuantityPerUnit());
        assertEquals(49.99, product.getUnitPrice());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Create two products with the same field values
        Product product1 = new Product(3, "EQUAL PRODUCT", "20 UNITS", 19.99);
        Product product2 = new Product(3, "EQUAL PRODUCT", "20 UNITS", 19.99);

        // Create a different product
        Product product3 = new Product(4, "DIFFERENT PRODUCT", "10 UNITS", 9.99);

        // Assert that product1 and product2 are equal and have the same hash code
        assertEquals(product1, product2, "Products with identical values should be equal");
        assertEquals(product1.hashCode(), product2.hashCode(), "HashCodes should be identical");

        // Assert that product1 and product3 are not equal
        assertNotEquals(product1, product3, "Products with different values should not be equal");
    }
}
