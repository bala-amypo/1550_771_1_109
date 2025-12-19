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

    // Many cards belong to one user
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

    // One card can have many reward rules
    @OneToMany(mappedBy = "creditCard")
    private List<RewardRule> rewardRules;

    public CreditCardRecord() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getUser() {
        return user;
    }
    public void setUser(UserProfile user) {
        this.user = user;
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
}
