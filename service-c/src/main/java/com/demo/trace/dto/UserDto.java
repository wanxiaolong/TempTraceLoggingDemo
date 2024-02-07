package com.demo.trace.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String homeAddress;
}
