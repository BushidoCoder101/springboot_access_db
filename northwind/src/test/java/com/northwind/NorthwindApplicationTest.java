package com.northwind;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NorthwindApplicationTest {

    // Verifies that the Spring Boot application context loads successfully.
    @Test
    void contextLoads() {
        // If the application context fails to load, this test will fail.
    }

    // Verifies that the main() method of your application runs without throwing an exception.
    @Test
    void mainMethodRunsWithoutException() {
        String[] args = {};
        assertDoesNotThrow(() -> NorthwindApplication.main(args));
    }
}
