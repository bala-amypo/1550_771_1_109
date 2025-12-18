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

    @PostMapping
    public ResponseEntity<UserProfile> createUser(@RequestBody UserProfile profile) {
        UserProfile user = userProfileService.createUser(profile);
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping
    public List<UserProfile> getAllUsers() {
        return userProfileService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserById(@PathVariable Long id) {
        UserProfile user = userProfileService.getUserById(id);
        if (user != null) {
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id,
                                               @RequestParam boolean active) {
        if (userProfileService.updateUserStatus(id, active) != null) {
            return ResponseEntity.status(200).body("Status Updated Successfully");
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/lookup/{userId}")
    public ResponseEntity<UserProfile> lookupUser(@PathVariable String userId) {
        UserProfile user = userProfileService.findByUserId(userId);
        if (user != null) {
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).build();
    }
}
