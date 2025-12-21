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
    private String userId; // Unique business identifier

    @NotBlank
    private String fullName;

    @Email
    @NotBlank
    private String email;  // Must be unique

    @NotBlank
    private String password; // Encrypted

    private String role = "USER"; // Defaults to USER

    private Boolean active = true;

    private LocalDateTime createdAt;

    // Many-to-Many with CreditCardRecord
    @ManyToMany
    @JoinTable(
        name = "user_favourite_cards",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private Set<CreditCardRecord> favouriteCards = new HashSet<>();

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.role == null) {
            this.role = "USER";
        }
        if (this.active == null) {
            this.active = true;
        }
    }

    // Getters and Setters
}
