package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RecommendationRecord{
    private long id;
    private long userId;
    private long purchaseIntentId;
    private long recommendedCardId;
    private Double expectedRewardValue;
    private String calculationDetailsJson;
    private LocalDateTime recommendedAt;

    
    public void setId(long id) {
        this.id = id;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public void setPurchaseIntentId(long purchaseIntentId) {
        this.purchaseIntentId = purchaseIntentId;
    }
    public void setRecommendedCardId(long recommendedCardId) {
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