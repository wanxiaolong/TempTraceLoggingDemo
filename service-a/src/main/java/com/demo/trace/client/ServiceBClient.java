package com.demo.trace.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-b", url = "http://localhost:8081")
public interface ServiceBClient {
    @GetMapping("/hellob")
    String hellob();
}
