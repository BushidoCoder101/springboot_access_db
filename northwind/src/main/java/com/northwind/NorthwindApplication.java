package com.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NorthwindApplication {
    public static void main(String[] args) {
        SpringApplication.run(NorthwindApplication.class, args);
    }
}
