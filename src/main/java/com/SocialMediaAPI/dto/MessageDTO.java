package com.SocialMediaAPI.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Сущность сообщения")
public class MessageDTO {

    private Long sender;
    private Long recipient;
    private String message;
    private LocalDateTime creationDate = LocalDateTime.now();
}
