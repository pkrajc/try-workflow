package com.example.workflow.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testResult() throws Exception {
        mockMvc.perform(get("/test")
                .accept(MediaType.ALL)).andExpect(
                        status().isOk())
                .andDo(result -> {
                    Map<String, Object> response = objectMapper.readValue(
                            result.getResponse().getContentAsString(),
                            new TypeReference<Map<String, Object>>() {
                            });

                    assertNotNull(response);
                    assertNotNull(response.get("result"));
                    assertTrue((boolean) response.get("result"));
                });
    }

    @Test
    void testFirst() throws Exception {
        mockMvc.perform(get("/first").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andDo(result -> {
                    Map<String, Object> response = objectMapper.readValue(
                            result.getResponse().getContentAsString(),
                            new TypeReference<Map<String, Object>>() {
                            });

                    assertNotNull(response);
                    assertNotNull(response.get("id"));
                    assertNotNull(response.get("name"));
                    assertNotNull(response.get("quantity"));
                });
    }
}
