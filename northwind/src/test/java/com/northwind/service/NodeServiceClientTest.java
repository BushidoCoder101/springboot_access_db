package com.northwind.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class NodeServiceClientTest {

    @Mock
    private RestTemplate restTemplate;
    
    @InjectMocks
    private NodeServiceClient nodeServiceClient;
    
    @Test
    public void testGetCompanies() throws Exception {
        // Set the nodeServiceUrl field to our expected value.
        Field field = NodeServiceClient.class.getDeclaredField("nodeServiceUrl");
        field.setAccessible(true);
        field.set(nodeServiceClient, "http://localhost:4000/api/companies");
        
        String expectedResponse = "[{\"id\":1,\"name\":\"Company A\"}]";
        
        // Stub the RestTemplate call.
        when(restTemplate.getForObject("http://localhost:4000/api/companies", String.class))
            .thenReturn(expectedResponse);
        
        // Call the service method.
        String actualResponse = nodeServiceClient.getCompanies();
        
        // Verify the result.
        assertEquals(expectedResponse, actualResponse);
    }
}
