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
    private UserProfile userId;

    // Many-to-One → PurchaseIntentRecord
    @ManyToOne
    @JoinColumn(name = "purchase_intent_id", nullable = false)
    private PurchaseIntentRecord purchaseIntentId;

    // Many-to-One → CreditCardRecord
    @ManyToOne
    @JoinColumn(name = "recommended_card_id", nullable = false)
    private CreditCardRecord recommendedCardId;

    @Min(0)
    private Double expectedRewardValue;

    @Column(columnDefinition = "TEXT")
    private String calculationDetailsJson;

    private LocalDateTime recommendedAt;

    @PrePersist
    public void onCreate() {
        this.recommendedAt = LocalDateTime.now();
    }

    public RecommendationRecord(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getUserId() {
        return user;
    }

    public void setUserId(UserProfile userId) {
        this.user = user;
    }

    public PurchaseIntentRecord getPurchaseIntentId() {
        return purchaseIntentId;
    }

    public void setPurchaseIntentId(PurchaseIntentRecord purchaseIntentId) {
        this.purchaseIntent = purchaseIntentId;
    }

    public CreditCardRecord getRecommendedCardId() {
        return recommendedCardId;
    }

    public void setRecommendedCardId(CreditCardRecord recommendedCardId) {
        this.recommendedCard = recommendedCardId;
    }

    public Double getExpectedRewardValue() {
        return expectedRewardValue;
    }

    public void setExpectedRewardValue(Double expectedRewardValue) {
        this.expectedRewardValue = expectedRewardValue;
    }

    public String getCalculationDetailsJson() {
        return calculationDetailsJson;
    }

    public void setCalculationDetailsJson(String calculationDetailsJson) {
        this.calculationDetailsJson = calculationDetailsJson;
    }

    public LocalDateTime getRecommendedAt() {
        return recommendedAt;
    }

    public void setRecommendedAt(LocalDateTime recommendedAt) {
        this.recommendedAt = recommendedAt;
    }
}
