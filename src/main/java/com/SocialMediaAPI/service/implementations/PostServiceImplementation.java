package com.SocialMediaAPI.service.implementations;

import com.SocialMediaAPI.model.Post;
import com.SocialMediaAPI.repository.PostRepository;
import com.SocialMediaAPI.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PostServiceImplementation implements PostService {


    @Autowired
    private final PostRepository repository;

    public PostServiceImplementation(PostRepository repository) throws ClassNotFoundException, SQLException {

        this.repository = repository;
    }


    @Override
    public List<Post> getMy(Long id) {
        return repository.findByCreator(id);
    }

    @Override
    public Post get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Post> getAll(Pageable pageable, Long id) {
        return repository.findAllByFollower(pageable, id);
    }


    @Override
    public Post create(Post data) {
        return repository.save(data);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        Post value = repository.findById(id).orElse(null);
        if (value != null) {
            repository.delete(value);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().body("Пост не найден");
        }
    }

    @Override
    public Post update(Post data) {
        return repository.save(data);
    }


}
