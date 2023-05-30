package com.SocialMediaAPI.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "followers", schema = "media")
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "id")
    private Long id;
    @Schema(description = "Блогер")
    private Long bloger;
    @Schema(description = "Подписчик")
    private Long follower;


    public Follower(Long bloger, Long follower) {
        this.bloger = bloger;
        this.follower = follower;
    }
}
