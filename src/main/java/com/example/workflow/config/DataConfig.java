package com.example.workflow.config;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    @Bean
    public CommandLineRunner testConnection(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection()) {
                System.out.println("Database connection successful: " + !conn.isClosed());
            } catch (Exception e) {
                System.err.println("Database connection failed: " + e.getMessage());
            }
        };
    }
}
