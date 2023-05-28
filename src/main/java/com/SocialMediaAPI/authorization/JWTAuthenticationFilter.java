package com.SocialMediaAPI.authorization;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Timestamp;
import java.util.Set;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

//    @Autowired
//    private JWTGenerator tokenGenerator;
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//
//    private String getJWTFromRequest(HttpServletRequest request) {
//        System.out.println("getJWTFromRequest");
//        String bearerToken = request.getHeader("Authorization");
//        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7, bearerToken.length());
//        }
//        return null;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
//        System.out.println("doFilterInternal");
//        String token = getJWTFromRequest(request);
//        System.out.println("token" +token);
//        if(StringUtils.hasText(token) && tokenGenerator.validateToken(token) ) {
//            String username = tokenGenerator.getUsernameFromJWT(token);
//            System.out.println("username" + username);
//            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
//            System.out.println(333);
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,
//                    userDetails.getAuthorities());
//            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        }
//       else if( token == null){
////            String token = jwtGenerator.generateToken(authentication);
////            System.out.println("User signed-in successfully!." + token);
////            return new ResponseEntity<>("User signed-in successfully!."+ token, HttpStatus.OK);
////            System.out.println(11);
////            final String authorization = request.getHeader("Authorization");
////            if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
////                // Authorization: Basic base64credentials
////                String base64Credentials = authorization.substring("Basic".length()).trim();
////                byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
////                String credentials = new String(credDecoded, StandardCharsets.UTF_8);
////                // credentials = username:password
////                final String[] values = credentials.split(":", 2);
////                for (int i = 0; i < values.length; i++){
////                    System.out.println(values[i]);
////                }
////                UserDetails userDetails = customUserDetailsService.loadUserByUsername(values[0]);
////                Authentication authentication =  authenticate(new UsernamePasswordAuthenticationToken(
////                        loginRequest.getUsername(), loginRequest.getPassword());
////
////                UserDetails userDetails = customUserDetailsService.loadUserByUsername(values[0]);
////                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,
////                        userDetails.getAuthorities());
////                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
////                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
////                SecurityContextHolder.getContext().setAuthentication(
////            }
//
////            request.getAuthType()
////            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
////                    loginRequest.getUsername(), loginRequest.getPassword()));
////            System.out.println(666);
////            SecurityContextHolder.getContext().setAuthentication(authentication);
////            System.out.println(777);
//////        SecurityContextHolder.getContext().setAuthentication(authentication);
////            String token = jwtGenerator.generateToken(authentication);
//        }
//        filterChain.doFilter(request, response);
//    }
//}


//    @Autowired
//    private final AuthenticationManager authenticationManager;


    @Autowired
    private JWTGenerator tokenGenerator;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


//        if (path.contains("/api/auth/")) {
//
//        }
//        else {
            String token = getJWTFromRequest(request);

            if (StringUtils.hasText(token) && tokenGenerator.validateToken(token)) {
                String username = tokenGenerator.getUsernameFromJWT(token);

                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,
                        userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
//        }
        filterChain.doFilter(request, response);
    }

    private String getJWTFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
