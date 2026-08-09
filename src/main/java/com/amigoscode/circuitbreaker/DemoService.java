package com.amigoscode.circuitbreaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @CircuitBreaker(name = "demoBreaker", fallbackMethod = "fallback")
    public String riskyCall(boolean shouldFail) {
        if (shouldFail) {
            throw new RuntimeException("Something went wrong downstream");
        }
        return "Success!";
    }

    public String fallback(boolean shouldFail, Throwable t) {
        return "Fallback triggered — reason: " + t.getMessage();
    }
}