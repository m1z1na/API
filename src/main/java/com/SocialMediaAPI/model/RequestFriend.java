package com.SocialMediaAPI.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @IdClass(RequestFriendId.class)
@Table(name = "requests", schema = "media")
public class RequestFriend {
    @Id
    @Column(name = "user_from")
    @Schema(description = "Отправитель заявки")
    private Long userFrom;
    @Id
    @Column(name = "user_to")
    @Schema(description = "С кем хочет подружиться отправитель")
    private Long userTo;



}
