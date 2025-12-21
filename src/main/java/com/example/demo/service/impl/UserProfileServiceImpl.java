package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userRepo;

    public UserProfileServiceImpl(UserProfileRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserProfile register(UserProfile user) {

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new BadRequestException("Email is required");
        }

        return userRepo.save(user);
    }
}
