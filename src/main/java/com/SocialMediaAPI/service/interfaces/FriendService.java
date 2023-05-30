package com.SocialMediaAPI.service.interfaces;


import com.SocialMediaAPI.model.Follower;
import com.SocialMediaAPI.model.Friend;
import com.SocialMediaAPI.model.RequestFriend;
import org.springframework.http.ResponseEntity;


public interface FriendService {

    ResponseEntity<Follower> follow(Follower data);

    Follower getFollow(Long id);

    ResponseEntity unfollow(Long id);

    ResponseEntity<RequestFriend> sendRequest(RequestFriend request);

    ResponseEntity<Friend> acceptRequest(RequestFriend request);

    ResponseEntity<String> breakFriendship(Friend friend, Long id);

    ResponseEntity sendMessage(Long id);
}
