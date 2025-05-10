package com.northwind.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.northwind.service.NodeServiceClient;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@WebMvcTest(NodeController.class)
public class NodeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private NodeServiceClient nodeServiceClient;
    
    @Disabled
    @Test
    public void testGetCompaniesFromNode() throws Exception {
        String expectedResponse = "[{\"id\":1,\"name\":\"Company A\"}]";
        
        // Stub the service client.
        when(nodeServiceClient.getCompanies()).thenReturn(expectedResponse);
        
        // Perform GET /node/companies and verify the response.
        mockMvc.perform(get("/node/companies"))
               .andExpect(status().isOk())
               .andExpect(content().string(expectedResponse));
    }
}
