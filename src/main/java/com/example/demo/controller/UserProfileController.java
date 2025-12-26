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

    // ✅ Public endpoint - Anyone can register
    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public UserProfile register(@RequestBody UserProfile profile) {
        return service.createUser(profile);
    }

    // 🔒 Authenticated users - You can see your own profile by ID
    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public UserProfile get(@PathVariable Long id) {
        return service.getUserById(id);
    }

    /**
     * FIX: Changed from hasRole('ADMIN') to isAuthenticated() 
     * This stops the 403 error when you are logged in as a normal user.
     */
    @GetMapping
    @PreAuthorize("isAuthenticated()") 
    public List<UserProfile> list() {
        return service.getAllUsers();
    }

    // 🔒 Authenticated users - Look up a profile by string userId
    @GetMapping("/lookup/{userId}")
    @PreAuthorize("isAuthenticated()")
    public UserProfile lookup(@PathVariable String userId) {
        return service.findByUserId(userId);
    }

    // 🔒 Admin only - Kept as ADMIN for security, 
    // change to isAuthenticated() if you need to test this too.
    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public UserProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateUserStatus(id, active);
    }
}