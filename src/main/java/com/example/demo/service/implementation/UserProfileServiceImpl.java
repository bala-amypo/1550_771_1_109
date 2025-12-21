package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repo;

    public UserProfileServiceImpl(UserProfileRepository repo) {
        this.repo = repo;
    }

    public UserProfile register(UserProfile user) {
        return repo.save(user);
    }
}
