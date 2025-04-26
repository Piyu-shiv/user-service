package com.prodev.user.userservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prodev.user.userservice.model.request.UserLoginModel;
import com.prodev.user.userservice.model.response.UserResponseEntity;
import com.prodev.user.userservice.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private UserService userService;

    private Environment env;
    private AuthenticationManager authenticationManager = null;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        // TODO Auto-generated constructor stub
        super(authenticationManager);
        this.authenticationManager = authenticationManager;

    }
    public AuthenticationFilter(UserService userService, Environment env,
                                AuthenticationManager authenticationManager) {
        // TODO Auto-generated constructor stub
        super(authenticationManager);
        this.userService = userService;
        this.env = env;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        // TODO Auto-generated method stub
        try {
            System.out.println("heresdkj..9*********96*986......................................." + request);
            UserLoginModel cred = new ObjectMapper().readValue(request.getInputStream(), UserLoginModel.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(cred.getPhoneNo(), cred.getPassword(), new ArrayList<>()));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e + "caught error here");
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        // TODO Auto-generated method stub
        String userName = ((User) authResult.getPrincipal()).getUsername();
        UserResponseEntity user = userService.getUserByPhoneNo(userName);
        String token = Jwts.builder().setSubject(user.getUser().getId()).setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(env.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret")).compact();
        response.addHeader("token", token);
        response.addHeader("userId", user.getUser().getId());

    }
}
