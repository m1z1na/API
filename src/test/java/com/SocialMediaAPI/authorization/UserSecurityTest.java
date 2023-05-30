package com.SocialMediaAPI.authorization;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import com.SocialMediaAPI.model.UserEntity;
import com.SocialMediaAPI.repository.UserRepository;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.Optional;

@WebMvcTest
@RunWith(SpringRunner.class)
class UserSecurityTest {
    /*
    @MockBean
    private UserRepository userRepository;

    @Test
    public void checkUser(){
        UserEntity user = new UserEntity(3L, "test@mail", "test", "123", new ArrayList<>() );
        Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.of(user));
        UserSecurity userSecurity = new UserSecurity();
        Authentication authentication = new UsernamePasswordAuthenticationToken("test", "123");
        assertThat(userSecurity.hasUserId(authentication,3L),is(true));
    }

     */
}