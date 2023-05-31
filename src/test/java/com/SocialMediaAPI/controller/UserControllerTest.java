package com.SocialMediaAPI.controller;

import com.SocialMediaAPI.authorization.AuthForTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest extends AuthForTest {
/*
    @MockBean
    JWTGenerator jwtDecoder;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private FriendService friendService;
    @MockBean
    private UserRepository userData;
    @Inject
    private WebApplicationContext context;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }


    @Test
    public void follow() throws Exception {

        String token = setAuthentication("test", "123", session);
        Follower data = new Follower();
        mockMvc.perform(
                post("/api/v1/user/follow/3")
                        .content(objectMapper.writeValueAsString(new Follower(3L, 4L)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.bloger").value("3"))
                .andExpect((ResultMatcher) jsonPath("$.follower").value("4"));

    }

    @Test
    public void unfollow() throws Exception {
        String token = setAuthentication("test", "123", session);
        mockMvc.perform(
                post("/api/v1/user/unfollow/3")
                        .content(objectMapper.writeValueAsString(new Follower(3L, 4L)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void sendRequest() throws Exception {
        String token = setAuthentication("test", "123", session);

        mockMvc.perform(
                post("/api/v1/user/follow/4"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.userFrom").value("3"))
                .andExpect((ResultMatcher) jsonPath("$.userTo").value("4"));
    }

    @Test
    public void acceptRequest() throws Exception {
        String token = setAuthentication("test", "123", session);

        mockMvc.perform(
                post("/api/v1//user/acceptRequest/3"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id").value("3"))
                .andExpect((ResultMatcher) jsonPath("$.friend").value("4"));
    }

    @Test
    public void breakFriendship() throws Exception {
        String token = setAuthentication("test", "123", session);

        mockMvc.perform(
                post("/api/user/breakFriendship/4"))
                .andExpect(status().isOk());
    }

*/
}