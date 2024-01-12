package com.demo.trace.controller;

import com.demo.trace.client.ServiceBClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ServiceAController {

    @Autowired
    private ServiceBClient bClient;

    @GetMapping("/helloa")
    public String helloa() {
        log.info("Service A, calling service B...");
        String resp = bClient.hellob();
        log.info("Service A, get response of B: {}", resp);
        return resp;
    }
}
