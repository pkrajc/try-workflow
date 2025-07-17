package com.example.workflow.repository;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class InventoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public Map<String, Object> findFirst() {
        return jdbcTemplate.queryForMap("select * from dbo.Inventory where id = 1");
    }
}
