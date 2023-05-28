package com.SocialMediaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SpringBootApplication
public class SocialMediaApiApplication {

	public static void main(String[] args) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String password = encoder.encode("secret");
		SpringApplication.run(SocialMediaApiApplication.class, args);
	}




}
