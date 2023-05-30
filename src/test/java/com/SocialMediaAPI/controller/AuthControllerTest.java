package com.SocialMediaAPI.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class AuthControllerTest {

    @Test
    void login() {
    }

    @Test
    void register() {
    }
}