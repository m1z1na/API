package com.SocialMediaAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Сущность пользователя/регистрация")
public class RegisterDto {

    @Schema(description = "Email")
    @Email(message = "Email address has invalid format: ${validatedValue}",
            regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    @Size(min = 6, max = 100, message = "Email от 6 до 16 символов")
    private String email;

    @Pattern(message = "Bad formed person name: ${validatedValue}",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    @Size(min = 6, max = 16, message = "Имя пользователя от 6 до 16 символов")
    @Schema(description = "Имя пользователя")
    private String username;

    @Schema(description = "Пароль")
    @JsonProperty("password")
    @NotEmpty
    @Size(min = 8, max = 100, message = "Длина пароля от 8 до 100 символов")
    private String password;
}