package com.SocialMediaAPI.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @IdClass(Friend.class)
@Table(name = "friends", schema = "media")
public class Friend {
    @Id
    @Schema(description = "Пользователь")
    private Long id;
    @Id
    @Schema(description = "Друг пользователя")
    private Long friend;

}


