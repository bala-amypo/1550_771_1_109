package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(
    name = "reward_rules",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"card_id", "category"})
    }
)
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relationship added WITHOUT changing cardId
    @ManyToOne(optional = false)
    @JoinColumn(
        name = "card_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private CreditCardRecord creditCard;

    private Long cardId;
    private String category;
    private String rewardType;

    @Min(1)
    private Double multiplier;

    private boolean active;

    public RewardRule() {
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }
    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    // getters
    public Long getId() {
        return id;
    }
    public Long getCardId() {
        return cardId;
    }
    public String getCategory() {
        return category;
    }
    public String getRewardType() {
        return rewardType;
    }
    public Double getMultiplier() {
        return multiplier;
    }
    public boolean isActive() {
        return active;
    }
}
