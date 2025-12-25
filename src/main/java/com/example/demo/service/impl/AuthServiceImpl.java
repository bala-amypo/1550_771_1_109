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
    private final UserProfileRepository userProfileRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    // EXACT constructor order required by PDF Page 10 (Section 6.6) and Step 0
    public AuthServiceImpl(
            UserProfileService userService,
            UserProfileRepository userProfileRepository,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil) {
        this.userService = userService;
        this.userProfileRepository = userProfileRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public JwtResponse register(RegisterRequest req) {
        // 1. Validate uniqueness (Requirement PDF Page 8)
        if (userProfileRepository.existsByEmail(req.getEmail())) {
            throw new BadRequestException("Event code already exists"); // Based on duplicate requirements
        }
        
        // 2. Map DTO to Entity
        UserProfile user = new UserProfile();
        user.setFullName(req.getFullName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword()); // Password will be encoded inside userService.createUser
        user.setRole(req.getRole() != null ? req.getRole() : "USER");
        
        // Ensure userId is present if not provided in request
        String userId = (req.getUserId() != null) ? req.getUserId() : UUID.randomUUID().toString();
        if (userProfileRepository.existsByUserId(userId)) {
            throw new BadRequestException("User ID already exists");
        }
        user.setUserId(userId);
        user.setActive(true);

        // 3. Save User
        UserProfile savedUser = userService.createUser(user);

        // 4. Generate Token and Return
        String token = jwtUtil.generateToken(savedUser.getId(), savedUser.getEmail(), savedUser.getRole());
        return new JwtResponse(token, savedUser.getId(), savedUser.getEmail(), savedUser.getRole());
    }

    @Override
    public JwtResponse login(LoginRequest req) {
        // 1. Authenticate via Spring Security
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        // 2. Fetch User and check Active status (Requirement PDF Page 3)
        UserProfile user = userProfileRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new BadRequestException("User not found"));

        if (user.getActive() != null && !user.getActive()) {
            throw new BadRequestException("User account is inactive");
        }

        // 3. Generate Token and Return
        String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
        return new JwtResponse(token, user.getId(), user.getEmail(), user.getRole());
    }
}