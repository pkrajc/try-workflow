package com.example.workflow.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.workflow.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyService {
    private final InventoryRepository inventoryRepository;

    public boolean result(Boolean value) {
        return value;
    }

    public Map<String, Object> findFirst() {
        return inventoryRepository.findFirst();
    }
}
