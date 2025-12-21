package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "credit_cards")
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FIX: Replaced userId with a proper relationship
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    private String cardName;

    private String issuer;

    private String cardType;

    @Min(0)
    private Double annualFee;

    private String status;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RewardRule> rewardRules;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public void setAnnualFee(Double annualFee) {
        this.annualFee = annualFee;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    public Long getUserId() {
        return userId;
    }
    public String getCardName() {
        return cardName;
    }
    public String getIssuer() {
        return issuer;
    }
    public String getCardType() {
        return cardType;
    }
    public Double getAnnualFee() {
        return annualFee;
    }
    public String getStatus() {
        return status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
