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
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserProfileService userService;
    private final UserProfileRepository userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    // Exact constructor signature as per documentation (Page 10)
    public AuthServiceImpl(UserProfileService userService, UserProfileRepository userRepo, 
                           AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public JwtResponse register(RegisterRequest req) {
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new BadRequestException("Event code already exists"); // Based on Page 3 requirement
        }

        UserProfile user = new UserProfile();
        user.setFullName(req.getFullName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword()); // UserProfileService will encode this
        user.setRole(req.getRole() != null ? req.getRole() : "USER");
        user.setUserId(UUID.randomUUID().toString());
        user.setActive(true);

        UserProfile saved = userService.createUser(user);
        
        String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());
        return new JwtResponse(token, saved.getId(), saved.getEmail(), saved.getRole());
    }

    @Override
    public JwtResponse login(LoginRequest req) {
        // Authenticate via Spring Security
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        UserProfile user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!user.getActive()) {
            throw new BadRequestException("User account is inactive");
        }

        String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
        return new JwtResponse(token, user.getId(), user.getEmail(), user.getRole());
    }
}