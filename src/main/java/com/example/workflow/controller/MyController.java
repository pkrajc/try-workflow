package com.example.workflow.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.workflow.service.MyService;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MyController {
    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> test(@RequestParam(required = false) String param) {
        boolean result = myService.result(true);
        return ResponseEntity.ok().body(Map.of("result", result));
    }

}
