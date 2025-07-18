package com.example.workflow.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.workflow.repository.InventoryRepository;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {
    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private MyService myService;

    @Test
    void testResult() {
        boolean result = myService.result(true);
        assertTrue(result);
    }

    @Test
    void testFirst() {
        when(inventoryRepository.findFirst()).thenReturn(
                Map.of("id", 1, "name", "banana", "quantity", 10));

        Map<String, Object> result = myService.findFirst();

        assertNotNull(result);
        assertNotNull(result.get("id"));
        assertNotNull(result.get("name"));
        assertNotNull(result.get("quantity"));

        assertSame(1, result.get("id"));
        assertSame("banana", result.get("name"));
        assertSame(10, result.get("quantity"));

        verify(inventoryRepository, times(1)).findFirst();
    }
}
