package com.SocialMediaAPI.repository;

import com.SocialMediaAPI.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT p.id, p.description, p.text, p.creationdate, p.creator, p.logodata, p.logoname, p.size, p.contenttype  FROM media.posts p inner join media.followers c on c.bloger=p.creator where c.follower = ?1", nativeQuery = true)
    Page<Post> findAllByFollower(Pageable pageable, Long follower);

    List<Post> findByCreator(Long creator);

}

