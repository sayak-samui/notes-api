package com.amigoscode.circuitbreaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class FlakyServiceClient {
    private final RestClient restClient = RestClient.create("http://localhost:8080");

    @CircuitBreaker(name = "flakyService", fallbackMethod = "fallbackResponse")
    public String callFlakyService(boolean forceFail){
        return restClient.get()
                .uri("/api/flaky?forceFail="+forceFail)
                .retrieve()
                .body(String.class);
    }

    public String fallbackResponse(boolean forceFall,Throwable t) {
        return "Fallback: external service unavailable right now. (" + t.getMessage() + ")";
    }


}
