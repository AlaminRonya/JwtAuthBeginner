package com.alamin.jwttokenimplbasicauth.dto.request;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
