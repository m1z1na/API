package com.SocialMediaAPI.repository;

import com.SocialMediaAPI.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FollowerRepository  extends JpaRepository<Follower, Long>{
    Follower findAllByFollowerOrBloger( Long follower, Long bloger);
}
