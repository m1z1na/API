package com.SocialMediaAPI.repository;

import com.SocialMediaAPI.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
    UserEntity findByEmail(String email);
    Boolean existsByEmail(String email);
}


