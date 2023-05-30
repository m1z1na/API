package com.SocialMediaAPI.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Сущность пользователя/авторизация")
public class LoginDto {

    @Schema(description = "Имя пользователя")
    private String username;
    @Schema(description = "Пароль")
    private String password;
}