package com.amigoscode.circuitbreaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/api/demo")
    public String demo(@RequestParam(defaultValue = "false") boolean fail) {
        return demoService.riskyCall(fail);
    }
}