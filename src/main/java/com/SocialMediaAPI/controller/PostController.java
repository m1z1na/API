package com.SocialMediaAPI.controller;


import com.SocialMediaAPI.model.Post;
import com.SocialMediaAPI.model.UserEntity;
import com.SocialMediaAPI.repository.UserRepository;
import com.SocialMediaAPI.service.interfaces.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;


@RestController
@RequestMapping("/api/post")
//@EnableGlobalMethodSecurity(prePostEnabled=true)
@Tag(name = "Посты",
        description = "Класс-контроллер для взаимодействия с постами ")
public class PostController {

    @Autowired
    private final PostService postData;
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public PostController(PostService postData, UserRepository userRepository) {
        this.postData = postData;
        this.userRepository = userRepository;
    }


    //    @PreAuthorize("#userId == authentication.name")//("@userSecurity.hasUserId(authentication,#userId)")
//    @PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
    @Operation(summary = "Получить мои посты")
    @GetMapping(value = "/")
    public List<Post> findMyPost(@PathVariable int id, Authentication authentication) {

        UserEntity user = userRepository.findByUsername(authentication.getName()).orElse(null);
        return postData.getMy(user.getId());

    }


    @Operation(summary = "Создать поcт")
    @PostMapping(path = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
//    public ResponseEntity<Post> update(@RequestParam("file") MultipartFile file, NewPostDTO newPost )
    public ResponseEntity<Post> create(Authentication authentication,
                                       @RequestParam("text") String text,
                                       @RequestParam("description") String description,
                                       @RequestPart("file") MultipartFile file) throws IOException {
        Long value = userRepository.findByUsername(authentication.getName()).get().getId();
        Post post = new Post(value, file.getBytes(), file.getOriginalFilename(), description, text, file.getSize(), file.getContentType());


        ByteArrayResource resource = new ByteArrayResource(file.getBytes());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename(URLEncoder.encode(post.getLogoName(), StandardCharsets.UTF_8))
                                .build().toString())
                .body(this.postData.create(post));


    }


    @Operation(summary = "Обновить пост")
    @PutMapping(path = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
//    public ResponseEntity<Post> update(@RequestParam("file1") MultipartFile file, PostDTO newPost )
    public ResponseEntity<Post> update(@RequestParam("id") Long id,
                                       @RequestParam("text") String text,
                                       @RequestParam("description") String description,
                                       @RequestPart("file") MultipartFile file,
                                       Authentication authentication) throws IOException {
        Post post = postData.get(id);
        Long value = post.getCreator();
        if (value == userRepository.findByUsername(authentication.getName()).get().getId()) {
            post.setContentType(file.getContentType());
            post.setSize(file.getSize());
            post.setCreator(value);
            post.setLogoData(file.getBytes());
            post.setLogoName(file.getOriginalFilename());
            post.setDescription(description);
            post.setText(text);

            ByteArrayResource resource = new ByteArrayResource(file.getBytes());
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(resource.contentLength())
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            ContentDisposition.attachment()
                                    .filename(URLEncoder.encode(post.getLogoName(), StandardCharsets.UTF_8))
                                    .build().toString())
                    .body(this.postData.create(post));
        } else
            return ResponseEntity.status(403).build();

    }


    @Operation(summary = "Удалить пост")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id, Authentication authentication) {
        Long value = postData.get(id).getCreator();
        if (value == userRepository.findByUsername(authentication.getName()).get().getId()) {
            return postData.delete(id);
        } else {
            return ResponseEntity.status(403).build();
        }
    }


    @Operation(summary = "Получить посты по подпискам подписки")
    @GetMapping("/subscriptions")
    Page<Post> getAll(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
            @RequestParam(value = "sort", defaultValue = "creationDate") String sortField,
            @RequestParam(value = "sortBy", defaultValue = "DESC") Sort.Direction sort,
            Authentication authentication
    ) {
        Long value = userRepository.findByUsername(authentication.getName()).get().getId();
        return postData.getAll(PageRequest.of(offset, limit, Sort.by(sort, sortField)), value);
    }


}
