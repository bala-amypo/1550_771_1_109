package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class UserProfile{

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,unique=true)
    private String userId;

    @Column(nullable=false)
    private String fullName;

    @Email
    @Column(unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String role;

    private boolean active;

    @PastOrPresent
    private LocalDateTime createdAt;


    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    
    public Long getId() {
        return id;
    }
    public String getUserId() {
        return userId;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public boolean isActive() {
        return active;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    
}