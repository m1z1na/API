package com.SocialMediaAPI.controller;

import com.SocialMediaAPI.authorization.JWTGenerator;
import com.SocialMediaAPI.model.Role;
import com.SocialMediaAPI.model.RoleEntity;
import com.SocialMediaAPI.model.UserEntity;
import com.SocialMediaAPI.repository.FollowerRepository;
import com.SocialMediaAPI.repository.FriendRepository;
import com.SocialMediaAPI.repository.RequestFriendRepository;
import com.SocialMediaAPI.repository.UserRepository;
import com.SocialMediaAPI.service.implementations.CustomUserDetailsService;
import com.SocialMediaAPI.service.interfaces.FriendService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest extends TestCase {

    @MockBean
    private JWTGenerator jwtUtil;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FriendRepository friendRepository;

    @MockBean
    private FollowerRepository followerRepository;

    @MockBean
    private RequestFriendRepository requestfriendRepository;

    @MockBean
    private UserRepository userData;
    @MockBean
    private CustomUserDetailsService userDetailsService;
    @MockBean
    private FriendService friendService;

    @Test
    public void findSkillAll() throws Exception {
        List<RoleEntity> list = new ArrayList<>();
        list.add(new RoleEntity(Role.ROLE_USER));
        when(userData.findAll()).thenReturn(Arrays.asList(new UserEntity(1L, "test", "test", "test", list)));
        MvcResult result = mockMvc.perform(post("/api/auth/login").header("Authorization").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"username\": \"test\",\n" +
                        "    \"password\":  \"test\"\n" +
                        "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);


    }




}