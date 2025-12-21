package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RewardRule{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private Long cardId;
    @Column(nullable=false)
    private String category;
    @Column(nullable=false)
    private String rewardType;
    @Column(nullable=false)
    @Min(1)
    private Double multiplier;
    @Column(nullable=false)
    private boolean active;

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