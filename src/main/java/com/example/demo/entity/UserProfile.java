package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "user_profiles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "userId"),
        @UniqueConstraint(columnNames = "email")
    }
)
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String userId;

    private String fullName;

    @Email
    private String email;

    private String password;

    private String role = "USER";

    private Boolean active = true;

    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
        name = "user_favourite_cards",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private Set<CreditCardRecord> favouriteCards = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
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
