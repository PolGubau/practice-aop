package com.pol.learn.aop.aop.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public ResponseEntity<?> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello World");
        return ResponseEntity.ok(response);
    }

}
