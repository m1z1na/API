package com.SocialMediaAPI.repository;


import com.SocialMediaAPI.model.RequestFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestFriendRepository extends JpaRepository<RequestFriend, Long> {

    RequestFriend findRequestFriendByUserFrom( Long id);

    RequestFriend findRequestFriendByUserTo( Long id);
}
