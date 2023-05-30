package com.SocialMediaAPI.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AuthResponseDTO {
    @Schema(description = "Токен")
    private String accessToken;
    @Schema(description = "Тип")
    private String tokenType = "Bearer ";

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}