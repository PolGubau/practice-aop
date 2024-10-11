package com.pol.learn.aop.aop.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pol.learn.aop.aop.services.GreetingService;

@RestController
public class HelloController {

    private final GreetingService greetingService;

    HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/")
    public ResponseEntity<?> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.greet("World", "how are you?"));
        return ResponseEntity.ok(response);
    }

}
