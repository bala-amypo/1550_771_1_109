package com.example.demo.service.impl;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserProfileService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthServiceImpl implements AuthService {

    private final UserProfileService userService;
    private final UserProfileRepository userRepo;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(
            UserProfileService userService,
            UserProfileRepository userRepo,
            AuthenticationManager authManager,
            JwtUtil jwtUtil
    ) {
        this.userService = userService;
        this.userRepo = userRepo;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public JwtResponse register(RegisterRequest req) {
        UserProfile user = new UserProfile();
        user.setFullName(req.getFullName());
        user.setEmail(req.getEmail());
        user.setUserId(req.getUserId());
        user.setPassword(req.getPassword());
        user.setRole(req.getRole());

        UserProfile saved = userService.createUser(user);

        String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());

        return new JwtResponse(token, saved.getId(), saved.getEmail(), saved.getRole());
    }

    @Override
    public JwtResponse login(LoginRequest req) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        UserProfile user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!Boolean.TRUE.equals(user.getActive()))
            throw new BadRequestException("User is not active");

        String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());

        return new JwtResponse(token, user.getId(), user.getEmail(), user.getRole());
    }
}
