package com.SocialMediaAPI.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String username;
    private String password;
}