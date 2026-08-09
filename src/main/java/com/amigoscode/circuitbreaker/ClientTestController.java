package com.amigoscode.circuitbreaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientTestController {

    private final FlakyServiceClient flakyServiceClient;

    public ClientTestController(FlakyServiceClient flakyServiceClient) {
        this.flakyServiceClient = flakyServiceClient;
    }

    @GetMapping("/api/call-flaky")
    public String callFlaky(@RequestParam(defaultValue = "false") boolean forceFail) {
        return flakyServiceClient.callFlakyService(forceFail);
    }
}