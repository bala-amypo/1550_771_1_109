package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
@Table(name = "recommendations")
public class RecommendationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* =======================
       USER RELATIONSHIP
       ======================= */
    @ManyToOne(optional = false)
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private UserProfile userProfile;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    /* =======================
       PURCHASE INTENT RELATIONSHIP
       ======================= */
    @ManyToOne(optional = false)
    @JoinColumn(
        name = "purchase_intent_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private PurchaseIntentRecord purchaseIntent;

    @Column(name = "purchase_intent_id", nullable = false)
    private Long purchaseIntentId;

    /* =======================
       CREDIT CARD RELATIONSHIP
       ======================= */
    @ManyToOne(optional = false)
    @JoinColumn(
        name = "recommended_card_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private CreditCardRecord recommendedCard;

    @Column(name = "recommended_card_id", nullable = false)
    private Long recommendedCardId;

    /* =======================
       BUSINESS FIELDS
       ======================= */
    @Min(0)
    private Double expectedRewardValue;

    @Column(columnDefinition = "TEXT")
    private String calculationDetailsJson;

    private LocalDateTime recommendedAt;

    /* =======================
       CONSTRUCTOR
       ======================= */
    public RecommendationRecord() {
    }

    /* =======================
       AUTO TIMESTAMP
       ======================= */
    @PrePersist
    protected void onCreate() {
        this.recommendedAt = LocalDateTime.now();
    }

    /* =======================
       SETTERS
       ======================= */
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

    /* =======================
       GETTERS
       ======================= */
    public Long getId() {
        return id;
    }
    public Long getUserId() {
        return userId;
    }
    public Long getPurchaseIntentId() {
        return purchaseIntentId;
    }
    public Long getRecommendedCardId() {
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
