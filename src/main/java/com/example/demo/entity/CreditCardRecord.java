package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "credit_cards")
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One → UserProfile
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;  // Must reference a valid user

    @NotBlank
    private String cardName;

    @NotBlank
    private String issuer;

    private String cardType;

    @Min(0)
    private Double annualFee;

    private String status; // ACTIVE / INACTIVE

    private LocalDateTime createdAt;

    // One-to-Many with RewardRule
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RewardRule> rewardRules;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
}
