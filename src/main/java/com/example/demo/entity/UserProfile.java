package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userId;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;
    private String role;
    private Boolean active;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        if (role == null) role = "USER";
    }

    // getters & setters (ALL)
}
