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

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private CreditCardRecord creditCard;

    private String category;
    private String rewardType;

    @Min(1)
    private Double multiplier;

    private boolean active;

    public RewardRule() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public CreditCardRecord getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(CreditCardRecord creditCard) {
        this.creditCard = creditCard;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getRewardType() {
        return rewardType;
    }
    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public Double getMultiplier() {
        return multiplier;
    }
    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
