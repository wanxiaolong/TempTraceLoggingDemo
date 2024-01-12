package com.demo.trace.controller;

import com.demo.trace.client.ServiceCClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ServiceBController {

    @Autowired
    private ServiceCClient cClient;

    @GetMapping("/hellob")
    public String hellob() {
        log.info("Service B, calling service C...");
        String resp = cClient.helloc();
        log.info("Service B, get response of C: {}", resp);
        return resp;
    }
}
