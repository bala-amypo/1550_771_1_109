package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "credit_cards")
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserProfile userProfile;

    @Column(name = "user_id")
    private Long userId;

    @NotNull
    private String cardNumber;

    @NotNull
    private String cardName;

    @Min(1)
    private Double creditLimit;

    @NotNull
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL)
    private List<RewardRule> rewardRules;

    public CreditCardRecord() {
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setRewardRules(List<RewardRule> rewardRules) {
        this.rewardRules = rewardRules;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public Long getUserId() {
        return userId;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public String getCardName() {
        return cardName;
    }
    public Double getCreditLimit() {
        return creditLimit;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public List<RewardRule> getRewardRules() {
        return rewardRules;
    }
}
