package com.SocialMediaAPI.service.implementations;

import com.SocialMediaAPI.model.Follower;
import com.SocialMediaAPI.model.Friend;
import com.SocialMediaAPI.model.RequestFriend;
import com.SocialMediaAPI.repository.FollowerRepository;
import com.SocialMediaAPI.repository.FriendRepository;
import com.SocialMediaAPI.repository.RequestFriendRepository;
import com.SocialMediaAPI.service.interfaces.FriendService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImplementation implements FriendService {

    @Autowired
    private final FriendRepository friendRepository;
    @Autowired
    private final FollowerRepository followerRepository;
    @Autowired
    private final RequestFriendRepository requestfriendRepository;

    public FriendServiceImplementation(FollowerRepository repository, FriendRepository friendRepository, RequestFriendRepository requestfriendRepository) {
        this.followerRepository = repository;
        this.friendRepository = friendRepository;
        this.requestfriendRepository = requestfriendRepository;
    }

    @Override
    public ResponseEntity<Follower> follow(Follower data) {
        //проверка что не является уже подписчиком
        return ResponseEntity.ok().body(followerRepository.save(data));
    }

    @Override
    public Follower getFollow(Long id) {

        return followerRepository.findById(id).orElse(new Follower());
    }

    @Override
    public ResponseEntity unfollow(Long id, Long myId) {
        // !проверка что не является другом, если является дружбу нужно разоравать
        Friend friends = friendRepository.findByFriendAndId(id, myId);
        if (friends == null) {
            friends = friendRepository.findByFriendAndId(myId, id);
        }
        if (friends != null) {
            friendRepository.delete(friends);
        }
        followerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    public ResponseEntity<RequestFriend> sendRequest(RequestFriend request) {
        // проверка что еще нет заявки
        //? если заявка в мою сторону, то дружить?
        if (followerRepository.findAllByFollowerOrBloger(request.getUserFrom(), request.getUserFrom()) == null) {
            Follower follower = new Follower(request.getUserTo(), request.getUserFrom());
            followerRepository.save(follower);
        }
        return ResponseEntity.ok().body(requestfriendRepository.save(request));
    }

    @Override
    @Transactional
    public ResponseEntity<Friend> acceptRequest(RequestFriend request) {
        // принять дружбу и стать подписчиком

        Friend friend = new Friend(request.getUserFrom(), request.getUserTo());
        requestfriendRepository.delete(request);
        return ResponseEntity.ok().body(friendRepository.save(friend));

    }

    @Override
    public ResponseEntity<String> breakFriendship(Friend friend, Long id) {
        // проверить что они друзья? если да, то разорвать дружбу и отписаться

        Follower follower = new Follower();
        follower.setBloger(friend.getId() == id ? friend.getFriend() : friend.getId());
        follower.setFollower(id);
        followerRepository.delete(follower);
        friendRepository.delete(friend);
        return ResponseEntity.ok().body("");
    }

    @Override
    public ResponseEntity sendMessage(Long id) {
        /*тут должна быть реализация чата ? */
        return ResponseEntity.ok().build();
    }

}
