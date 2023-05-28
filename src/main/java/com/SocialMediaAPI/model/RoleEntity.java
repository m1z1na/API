package com.SocialMediaAPI.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleEntity {
    private int id;

    private String name;


    public RoleEntity(Role name) {
        this.name = name.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}