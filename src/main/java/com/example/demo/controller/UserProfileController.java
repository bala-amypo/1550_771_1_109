package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    // POST /api/users - Create user
    @PostMapping
    public ResponseEntity<UserProfile> createUser(@RequestBody UserProfile profile) {
        UserProfile user = userProfileService.createUser(profile);
        return ResponseEntity.status(201).body(user);
    }

    // GET /api/users - List all users
    @GetMapping
    public List<UserProfile> getAllUsers() {
        return userProfileService.getAllUsers();
    }

    // GET /api/users/{id} - Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserById(@PathVariable Long id) {
        UserProfile user = userProfileService.getUserById(id);
        if (user != null) {
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).build();
    }

    // PUT /api/users/{id}/status - Activate / Deactivate user
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id,
                                               @RequestParam boolean active) {
        if (userProfileService.updateUserStatus(id, active) != null) {
            return ResponseEntity.status(200).body("Status Updated Successfully");
        }
        return ResponseEntity.status(404).build();
    }

    // GET /api/users/lookup/{userId} - Lookup user by userId
    @GetMapping("/lookup/{userId}")
    public ResponseEntity<UserProfile> lookupUser(@PathVariable String userId) {
        UserProfile user = userProfileService.findByUserId(userId);
        if (user != null) {
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).build();
    }
}
