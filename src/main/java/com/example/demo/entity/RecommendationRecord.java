package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "recommendations")
public class RecommendationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Relationship added WITHOUT changing userId
    @ManyToOne(optional = false)
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private UserProfile user;

    // Relationship added WITHOUT changing purchaseIntentId
    @ManyToOne(optional = false)
    @JoinColumn(
        name = "purchase_intent_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private PurchaseIntentRecord purchaseIntent;

    // Relationship added WITHOUT changing recommendedCardId
    @ManyToOne(optional = false)
    @JoinColumn(
        name = "recommended_card_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private CreditCardRecord recommendedCard;

    private long userId;
    private long purchaseIntentId;
    private long recommendedCardId;

    @Min(0)
    private Double expectedRewardValue;

    private String calculationDetailsJson;

    @CreationTimestamp
    private LocalDateTime recommendedAt;

    public RecommendationRecord() {
    }

    // setters (UNCHANGED)
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

    // getters (UNCHANGED)
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
