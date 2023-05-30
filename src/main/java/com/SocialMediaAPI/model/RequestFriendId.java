package com.SocialMediaAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class RequestFriendId implements Serializable {
    @Id
    @Column(name = "user_from")
    private Long userFrom;
    @Id
    @Column(name = "user_to")
    private Long userTo;
}
