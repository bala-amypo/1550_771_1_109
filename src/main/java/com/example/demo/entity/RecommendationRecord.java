package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RecommendationRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false)
    private long userId;
    @Column(nullable=false)
    private long purchaseIntentId;
    @Column(nullable=false)
    private long recommendedCardId;
    @Column(nullable=false)
    @Min(0)
    private Double expectedRewardValue;
    @Column(nullable=false)
    private String calculationDetailsJson;
    @Column(nullable=false)
    private LocalDateTime recommendedAt;

    public RecommendationRecord(){

    }
    @PrePersist
    public void onCreate() {
        this.recommendedAt = LocalDateTime.now();
    }

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