package com.northwind.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NodeServiceClient {

    private final RestTemplate restTemplate;

    // Inject the Node.js service URL—defaults to http://localhost:4000/api/companies if not set in application.properties.
    @Value("${node.service.url:http://localhost:4000/api/companies}")
    private String nodeServiceUrl;

    public NodeServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Synchronous call to the Node.js API.
    public String getCompanies() {
        return restTemplate.getForObject(nodeServiceUrl, String.class);
    }
    
    //Optionally, an asynchronous version using @Async (you need to add @EnableAsync in your main application)
    @Async("taskExecutor")
    public CompletableFuture<String> getCompaniesAsync() {
        String result = restTemplate.getForObject(nodeServiceUrl, String.class);
        return CompletableFuture.completedFuture(result);
    }
}
