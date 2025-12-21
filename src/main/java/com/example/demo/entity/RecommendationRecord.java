package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Min;

@Entity
public class RecommendationRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private Long userId;
    @Column(nullable=false)
    private Long purchaseIntentId;
    @Column(nullable=false)
    private Long recommendedCardId;
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