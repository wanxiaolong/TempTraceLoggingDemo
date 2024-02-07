package com.demo.trace.controller;

import com.demo.trace.dto.UserDto;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ServiceCController {

    private Gson gson = new Gson();

    @GetMapping("/helloc")
    public String helloc() {
        log.info("Service C, return Hello World C");
        log.info("UserDto: {}", gson.toJson(createUser()));
        return "Hello World C";
    }

    private UserDto createUser() {
        UserDto dto = new UserDto();
        dto.setEmail("wanxiaolong@163.com");
        dto.setName("wanxiaolong");
        dto.setHomeAddress("Chengdu");
        dto.setPhoneNumber("18500008888");
        return dto;
    }
}
