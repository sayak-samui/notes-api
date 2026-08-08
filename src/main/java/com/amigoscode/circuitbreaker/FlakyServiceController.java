package com.amigoscode.circuitbreaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class FlakyServiceController {

    @GetMapping("/api/flaky")
    public String callFlakyService(@RequestParam(defaultValue = "false") boolean forceFail) {
        if (forceFail || ThreadLocalRandom.current().nextInt(100) < 50) {
            throw new RuntimeException("Simulated downstream failure");
        }
        return "Success from flaky service at " + System.currentTimeMillis();
    }
}