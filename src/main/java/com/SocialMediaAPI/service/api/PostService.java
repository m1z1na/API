package com.SocialMediaAPI.service.api;


import com.SocialMediaAPI.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PostService {

    List<Post> getMy(Long id);

    Post get(Long id);

    Page<Post> getAll(Pageable pageable, Long id);

    Post create(Post data);

    ResponseEntity<String> delete(Long id);

    Post update(Post data);
}
