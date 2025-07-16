package com.example.workflow.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {
    @InjectMocks
    private MyService myService;

    @Test
    void testResult() {
        boolean result = myService.result(false);
        assertTrue(result);
    }
}
