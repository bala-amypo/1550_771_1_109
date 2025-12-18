package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserProfile;

public interface UserProfileService {
    UserProfile createUser(UserProfile profile);
    UserProfile getUserById(Long id);
    UserProfile findByUserId(String userId);
    List<UserProfile> getAllUsers();  // changed return type to List<UserProfile>
    UserProfile updateUserStatus(Long id, boolean active);
}
