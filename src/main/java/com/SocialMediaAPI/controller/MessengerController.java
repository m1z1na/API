package com.SocialMediaAPI.controller;

import com.SocialMediaAPI.model.Friend;
import com.SocialMediaAPI.model.RequestFriend;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messenger")
@Tag(name = "Мои друзья",
        description = "Класс-контроллер для чата")
public class MessengerController {

    @Operation(summary = "Получить всех друзей")
    @GetMapping("/getFriend")
    public String getFriend() {
        return "Тут будет чат";
    }

    @Operation(summary = "Отправить сообщение другу")
    @PostMapping("/sendMessage/{id}")
    public String sendMessage(@RequestBody String text) {
        return "Тут будет чат";
    }

    @Operation(summary = "Отобразить чат с ...")
    @PostMapping("/getChat/{id}")
    public String getChat(@RequestParam Long id) {
        return "Тут будет чат";
    }

}
