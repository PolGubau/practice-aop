package com.pol.learn.aop.aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet(String person, String phrase) {
        String greeting = "Hello " + person + ", " + phrase;
        System.out.println(greeting);
        return greeting;
    }

    @Override
    public String greetError(String person, String phrase) {
        throw new RuntimeException("Error in greeting");
    }

}
