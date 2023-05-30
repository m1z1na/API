package com.SocialMediaAPI.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class FriendId implements Serializable {
    @Id
    private Long id;
    @Id
    private Long friend;
}
