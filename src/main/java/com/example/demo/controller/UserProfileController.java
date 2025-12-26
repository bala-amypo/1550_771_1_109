package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    // ✅ Public endpoint
    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public UserProfile register(@RequestBody UserProfile profile) {
        return service.createUser(profile);
    }

    // 🔒 Authenticated users only
    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public UserProfile get(@PathVariable Long id) {
        return service.getUserById(id);
    }

    // 🔒 Admin only
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserProfile> list() {
        return service.getAllUsers();
    }

    // 🔒 Admin only (THIS FIXES YOUR 403 CONFUSION)
    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public UserProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateUserStatus(id, active);
    }

    // 🔒 Authenticated users
    @GetMapping("/lookup/{userId}")
    @PreAuthorize("isAuthenticated()")
    public UserProfile lookup(@PathVariable String userId) {
        return service.findByUserId(userId);
    }
}
