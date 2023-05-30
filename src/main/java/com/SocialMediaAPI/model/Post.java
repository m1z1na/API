package com.SocialMediaAPI.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts", schema = "media")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "id")
    private Long id;
    @Schema(description = "Заголовок поста")
    private String description;
    @Schema(description = "Текст поста")
    private String text;
    @Schema(description = "Имя файла")
    @Column(name = "logoname")
    private String logoName;
    @Schema(description = "Размер файла")
    @Column(name = "size")
    private Long size;
    @Schema(description = "Тип файла")
    @Column(name = "contenttype")
    private String contentType;
    @Lob
    @Schema(description = "Файл")
    @Column(name = "logodata", length = 16000000)
    //    @Type(type = "org.hibernate.type.ImageType")
    @Basic(fetch = FetchType.LAZY) // I've read this is default, but anyway...
    private byte[] logoData;
    private Long creator;

    @Column(name = "creationdate")
    private LocalDateTime creationDate = LocalDateTime.now();


    public Post(Long creator, byte[] logoData, String logoName, String description, String text, Long size, String contentType) {
        this.creator = creator;
        this.logoData = logoData;
        this.logoName = logoName;
        this.description = description;
        this.text = text;
        this.size = size;
        this.contentType = contentType;
    }
}
