package com.SocialMediaAPI.repository;

import com.SocialMediaAPI.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long>{

}
