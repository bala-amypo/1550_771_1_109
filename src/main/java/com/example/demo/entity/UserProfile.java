package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(
    name = "user_profiles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id"}),
        @UniqueConstraint(columnNames = {"email"})
    }
)
public class UserProfile {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    private String fullName;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'USER'")
    private String role;

    private boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Many-to-Many favourite cards
    @ManyToMany
    @JoinTable(
        name = "user_favourite_cards",
        joinColumns = @JoinColumn(name = "user_profile_id"),
        inverseJoinColumns = @JoinColumn(name = "credit_card_id")
    )
    private Set<CreditCardRecord> favouriteCards;

    // Default constructor (unchanged)
    public UserProfile() {
    }

    public UserProfile(String userId, String fullName, String email, String password, String role, boolean active,
            LocalDateTime createdAt) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
        this.createdAt = createdAt;
    }

    // setters (unchanged)
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

    // getters (unchanged)
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
