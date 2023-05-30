package com.SocialMediaAPI.controller;


import com.SocialMediaAPI.authorization.JWTGenerator;
import com.SocialMediaAPI.dto.AuthResponseDTO;
import com.SocialMediaAPI.dto.LoginDto;
import com.SocialMediaAPI.dto.RegisterDto;
import com.SocialMediaAPI.model.UserEntity;
import com.SocialMediaAPI.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Регистрации/Аутентификация",
        description = "Класс-контроллер для регистрации/аутентификация")
public class AuthController {

    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final JWTGenerator jwtGenerator;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          UserRepository userRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }


    @PostMapping("/login")
    @Operation(summary = "Аутентификация по логину и паролю")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Parameter(description = "Форма регистрации") LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword(), Set.of(new SimpleGrantedAuthority("ROLE_USER"))));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }


    @PostMapping("/register")
    @Operation(summary = "Регистрация")
    public ResponseEntity<String> register( @Valid @RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Имя пользователя уже занято!", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>("Email уже используется!", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setEmail(registerDto.getEmail());
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
        userRepository.save(user);

        return new ResponseEntity<>("Вы успешно зарегестрированы!", HttpStatus.OK);
    }
}