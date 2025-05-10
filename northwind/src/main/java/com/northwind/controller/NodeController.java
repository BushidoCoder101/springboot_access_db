// src/main/java/com/northwind/controller/NodeController.java
package com.northwind.controller;

import com.northwind.service.NodeServiceClient;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NodeController {

    private final NodeServiceClient nodeServiceClient;

    public NodeController(NodeServiceClient nodeServiceClient) {
        this.nodeServiceClient = nodeServiceClient;
    }

    @GetMapping("/node/companies")
    public ResponseEntity<String> getCompaniesFromNode() {
        String response = nodeServiceClient.getCompanies();
        return ResponseEntity.ok(response);
    }
    
  
    @GetMapping("/node/companies/async")
    public CompletableFuture<ResponseEntity<String>> getCompaniesFromNodeAsync() {
        return nodeServiceClient.getCompaniesAsync().thenApply(ResponseEntity::ok);
    }
}
