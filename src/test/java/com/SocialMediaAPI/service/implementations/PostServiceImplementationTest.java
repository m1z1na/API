package com.SocialMediaAPI.service.implementations;

import com.SocialMediaAPI.model.Post;
import com.SocialMediaAPI.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceImplementationTest {
/*

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImplementation postService;

    @Test
    public void PostService_CreatePost_ReturnsPostDto() {
        Post post = Post.builder()
                .description("Это заголовок")
                .text("Это текст").build();
//      Post post = PostDto.builder().name("pickachu").type("electric").build();
        when(postRepository.save(Mockito.any(Post.class))).thenReturn(post);
        Post savedPost = postService.create(post);
        Assertions.assertThat(savedPost).isNotNull();
    }

    @Test
    public void PostService_GetAllMyPost_ReturnsResponseDto() {
        Page<Post> posts = Mockito.mock(Page.class);
        when(postRepository.findAll(Mockito.any(Pageable.class))).thenReturn(posts);

        List<Post> savePost = postService.getMy(3L);
        Assertions.assertThat(savePost).isNotNull();
    }

    @Test
    public void PostService_FindById_ReturnPost() {
        Long postId = 1L;
        Post post = Post.builder().id(1L).text("test").description("descr").creator(1L).build();
        when(postRepository.findById(postId)).thenReturn(Optional.ofNullable(post));

        Post postReturn = postService.get(postId);
        Assertions.assertThat(post).isNotNull();
    }


    @Test
    public void PostService_UpdatePost_ReturnPost() {
        Long postId = 1L;
        Post post = Post.builder().id(1L).text("test").description("descr").creator(1L).build();
        Post postDto = Post.builder().id(1L).text("test").description("descr").creator(1L).build();

        when(postRepository.findById(postId)).thenReturn(Optional.ofNullable(post));
        when(postRepository.save(post)).thenReturn(post);

        Post updateReturn = postService.update(postDto);
        Assertions.assertThat(updateReturn).isNotNull();
    }

    @Test
    public void PostService_DeletePostById_ReturnVoid() {
        Long postId = 1L;
        Post post = Post.builder().id(1L).text("test").description("descr").creator(1L).build();
        when(postRepository.findById(postId)).thenReturn(Optional.ofNullable(post));

        doNothing().when(postRepository).delete(post);
        assertAll(() -> postService.delete(postId));
    }

 */
}