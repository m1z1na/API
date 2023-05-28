package com.SocialMediaAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "posts", schema = "media")
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String description;
    private String text;
    private LocalDateTime creationDate = LocalDateTime.now();

}
