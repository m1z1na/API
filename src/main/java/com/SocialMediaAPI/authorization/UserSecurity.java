package com.SocialMediaAPI.authorization;

import com.SocialMediaAPI.model.UserEntity;
import com.SocialMediaAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {

    @Autowired
    UserRepository userRepo;

    public boolean hasUserId(Authentication authentication, Long userId) {
        UserEntity user = userRepo.findByUsername(authentication.getName()).orElse(null);
        Long userID = user.getId();
        return userID == userId;

    }
}