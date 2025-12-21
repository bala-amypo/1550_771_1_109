package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "reward_rules",
    uniqueConstraints = @UniqueConstraint(columnNames = {"card_id", "category"})
)
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One → CreditCardRecord
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private CreditCardRecord card;

    @NotBlank
    private String category; // Unique per card

    private String rewardType; // cashback / points

    @Min(1)
    private Double multiplier; // must be > 0

    private Boolean active = true;

    public RewardRule(){
    
    }
     
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
