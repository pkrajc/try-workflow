package com.example.workflow.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

@SpringBootTest(properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
public class MyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("""
                    CREATE SCHEMA IF NOT EXISTS dbo;
                    DROP TABLE IF EXISTS dbo.Inventory;
                    CREATE TABLE dbo.Inventory(id INT PRIMARY KEY, name VARCHAR(255), quantity INT);
                    INSERT INTO dbo.Inventory VALUES(1, 'banana', 150);
                    INSERT INTO dbo.Inventory VALUES(2, 'grape', 200);
                    SELECT * FROM dbo.Inventory ORDER BY id;
                    UPDATE dbo.Inventory SET name='Hi' WHERE id=2;
                    DELETE FROM dbo.Inventory WHERE id=2;
                """);
    }

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
                    assertNotNull(response.get("ID"));
                    assertNotNull(response.get("NAME"));
                    assertNotNull(response.get("QUANTITY"));
                });
    }
}
