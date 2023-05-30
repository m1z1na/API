package com.SocialMediaAPI.controller;

import com.SocialMediaAPI.model.Follower;
import com.SocialMediaAPI.model.Friend;
import com.SocialMediaAPI.model.RequestFriend;
import com.SocialMediaAPI.repository.UserRepository;
import com.SocialMediaAPI.service.interfaces.FriendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@Tag(name = "Подписки",
        description = "Класс-контроллер для подписки")
public class UserController {

    @Autowired
    private final FriendService friendData;
    @Autowired
    private final UserRepository userData;


    @Autowired
    public UserController(FriendService friendData, UserRepository userData) {
        this.friendData = friendData;
        this.userData = userData;
    }


    @Operation(summary = "Подписаться")
    @PostMapping("/follow/{id}")
    public ResponseEntity<Follower> follow(@PathVariable @Parameter(description = "id на которого хотят подписаться") Long id, Authentication authentication) {
        Long userId = userData.findByUsername(authentication.getName()).get().getId();
        return friendData.follow(new Follower(id, userId));
    }

    @Operation(summary = "Отписаться")
    @DeleteMapping("unfollow/{id}")
    public ResponseEntity delete(@PathVariable
                                 @Parameter(description = "id записи") Long id, Authentication authentication) {
        Long userId = userData.findByUsername(authentication.getName()).get().getId();
        Follower follower = friendData.getFollow(id);
        if (follower.getId() == 0 || follower.getFollower() != userId) {
            return ResponseEntity.status(403).body("Доступ запрещен");
        } else {
            return friendData.unfollow(id, userId );
        }
    }


    @Operation(summary = "Подружиться")
    @PostMapping("/sendRequest/{id}")
    public ResponseEntity<RequestFriend> sendRequest(@PathVariable @Parameter(description = "id с кем хотят подписаться") Long id, Authentication authentication) {
        Long userId = userData.findByUsername(authentication.getName()).get().getId();
        return friendData.sendRequest(new RequestFriend(id, userId));


    }

    @Operation(summary = "Принять предложение о дружбе")
    @PostMapping("/acceptRequest/{id}")
    public ResponseEntity<Friend> acceptRequest(@PathVariable @Parameter(description = "id записи") Long id, Authentication authentication) {
        Long userId = userData.findByUsername(authentication.getName()).get().getId();
        return friendData.acceptRequest(new RequestFriend(id, userId));

    }

    @Operation(summary = "Разорвать дружбу")
    @PostMapping("/breakFriendship/{id}")
    public ResponseEntity<String> breakFriendship(@PathVariable @Parameter(description = "id записи") Long id, Authentication authentication) {
        Long userId = userData.findByUsername(authentication.getName()).get().getId();
        return friendData.breakFriendship(new Friend(id, userId), userId);

    }

}
