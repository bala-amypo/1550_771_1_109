package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "credit_cards")
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Owning user of the card
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "card_name", nullable = false)
    @NotBlank
    private String cardName;

    @Column(name = "issuer", nullable = false)
    @NotBlank
    private String issuer;

    @Column(name = "card_type", nullable = false)
    @NotBlank
    private String cardType;

    @Column(name = "annual_fee", nullable = false)
    @Min(0)
    private Double annualFee;

    @Column(name = "status", nullable = false)
    @NotBlank
    private String status; // "ACTIVE" or "INACTIVE"

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Many-to-Many with UserProfile for favourite cards
    @ManyToMany(mappedBy = "favouriteCards")
    private Set<UserProfile> favouritedByUsers = new HashSet<>();

    // One-to-Many with RewardRule
    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RewardRule> rewardRules = new HashSet<>();

    public CreditCardRecord() {
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "ACTIVE";
        }
        if (this.annualFee == null) {
            this.annualFee = 0.0;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Double getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(Double annualFee) {
        this.annualFee = annualFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Set<UserProfile> getFavouritedByUsers() {
        return favouritedByUsers;
    }

    public void setFavouritedByUsers(Set<UserProfile> favouritedByUsers) {
        this.favouritedByUsers = favouritedByUsers;
    }

    public Set<RewardRule> getRewardRules() {
        return rewardRules;
    }

    public void setRewardRules(Set<RewardRule> rewardRules) {
        this.rewardRules = rewardRules;
    }
}
