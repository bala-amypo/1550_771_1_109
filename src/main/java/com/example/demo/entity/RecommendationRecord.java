package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "recommendations")
public class RecommendationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    @ManyToOne
    @JoinColumn(name = "purchase_intent_id", nullable = false)
    private PurchaseIntentRecord purchaseIntent;

    @ManyToOne
    @JoinColumn(name = "recommended_card_id", nullable = false)
    private CreditCardRecord recommendedCard;

    @Min(0)
    private Double expectedRewardValue;

    @Column(columnDefinition = "TEXT")
    private String calculationDetailsJson;

    private LocalDateTime recommendedAt;

    @PrePersist
    public void prePersist() {
        this.recommendedAt = LocalDateTime.now();
    }

    // -------- Getters & Setters --------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }

    public PurchaseIntentRecord getPurchaseIntent() { return purchaseIntent; }
    public void setPurchaseIntent(PurchaseIntentRecord purchaseIntent) { this.purchaseIntent = purchaseIntent; }

    public CreditCardRecord getRecommendedCard() { return recommendedCard; }
    public void setRecommendedCard(CreditCardRecord recommendedCard) { this.recommendedCard = recommendedCard; }

    public Double getExpectedRewardValue() { return expectedRewardValue; }
    public void setExpectedRewardValue(Double expectedRewardValue) { this.expectedRewardValue = expectedRewardValue; }

    public String getCalculationDetailsJson() { return calculationDetailsJson; }
    public void setCalculationDetailsJson(String calculationDetailsJson) { this.calculationDetailsJson = calculationDetailsJson; }

    public LocalDateTime getRecommendedAt() { return recommendedAt; }
    public void setRecommendedAt(LocalDateTime recommendedAt) { this.recommendedAt = recommendedAt; }
}
