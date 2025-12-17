package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserProfile;

@Service
public interface UserProfileService {
    UserProfile createUser(UserProfile profile);
    UserProfile getUserById(Long id);
    UserProfile findByUserId(String userId);
    UserProfile getAllUsers();
    UserProfile updateUserStatus(Long id,boolean active);
}