package com.SocialMediaAPI.controller;

import com.SocialMediaAPI.authorization.AuthForTest;
import com.SocialMediaAPI.dto.LoginDto;
import com.SocialMediaAPI.dto.RegisterDto;
import com.SocialMediaAPI.model.UserEntity;
import com.SocialMediaAPI.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(AuthController.class)
class AuthControllerTest extends AuthForTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private AuthenticationManager authenticationManager;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void login() throws Exception {

        LoginDto login = new LoginDto("test", "123");
        UserEntity user = UserEntity.builder().username("test").password("123").build();
        Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.of(user));

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(login)))
                .andExpect(status().isOk());

    }

    @Test
    void register() throws Exception {

        RegisterDto register = new RegisterDto("test", "email.ru", "123");
        UserEntity user = UserEntity.builder().username("test").password("123").build();
        Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.of(user));

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(register)))
                .andExpect(status().isCreated());

    }


}