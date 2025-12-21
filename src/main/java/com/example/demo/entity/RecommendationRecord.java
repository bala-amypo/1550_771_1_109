package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recommendations")
public class RecommendationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double expectedRewardValue;
    private String calculationDetailsJson;
    private LocalDateTime recommendedAt = LocalDateTime.now();

    @ManyToOne
    private UserProfile user;

    @ManyToOne
    private PurchaseIntentRecord purchaseIntent;

    @ManyToOne
    private CreditCardRecord recommendedCard;

    public void setId(Long id) {
        this.id = id;
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

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public void setPurchaseIntent(PurchaseIntentRecord purchaseIntent) {
        this.purchaseIntent = purchaseIntent;
    }

    public void setRecommendedCard(CreditCardRecord recommendedCard) {
        this.recommendedCard = recommendedCard;
    }

    public Long getId() {
        return id;
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

    public UserProfile getUser() {
        return user;
    }

    public PurchaseIntentRecord getPurchaseIntent() {
        return purchaseIntent;
    }

    public CreditCardRecord getRecommendedCard() {
        return recommendedCard;
    }

    
    // getters and setters

    
}
