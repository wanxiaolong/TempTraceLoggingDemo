package com.demo.trace.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ServiceCController {

    @GetMapping("/helloc")
    public String helloc() {
        log.info("Service C, return Hello World C");
        return "Hello World C";
    }
}
