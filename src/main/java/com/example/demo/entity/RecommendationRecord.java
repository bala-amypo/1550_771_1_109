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

    // Many-to-One → UserProfile
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    // Many-to-One → PurchaseIntentRecord
    @ManyToOne
    @JoinColumn(name = "purchase_intent_id", nullable = false)
    private PurchaseIntentRecord purchaseIntent;

    // Many-to-One → CreditCardRecord
    @ManyToOne
    @JoinColumn(name = "recommended_card_id", nullable = false)
    private CreditCardRecord recommendedCard;

    @Min(0)
    private Double expectedRewardValue;

    @Column(columnDefinition = "TEXT")
    private String calculationDetailsJson;

    private LocalDateTime recommendedAt;

    @PrePersist
    public void onCreate() {
        this.recommendedAt = LocalDateTime.now();
    }
     public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setPurchaseIntentId(Long purchaseIntentId) {
        this.purchaseIntentId = purchaseIntentId;
    }
    public void setRecommendedCardId(Long recommendedCardId) {
        this.recommendedCardId = recommendedCardId;
    }
    public void setExpectedRewardValue(Double expectedRewardValue) {
        this.expectedRewardValue = expectedRewardValue;
    }
    public void setCalculationDetailsJson(String calculationDetailsJson) {
        this.calculationDetailsJson = calculationDetailsJson;
    }
    public void setRecommendedAt(LocalDateTime recommendedAt) {
        this.recommendedAt = recommendedAt;
    }
    public long getId() {
        return id;
    }
    public long getUserId() {
        return userId;
    }
    public long getPurchaseIntentId() {
        return purchaseIntentId;
    }
    public long getRecommendedCardId() {
        return recommendedCardId;
    }
    public Double getExpectedRewardValue() {
        return expectedRewardValue;
    }
    public String getCalculationDetailsJson() {
        return calculationDetailsJson;
    }
    public LocalDateTime getRecommendedAt() {
        return recommendedAt;
    }

}
