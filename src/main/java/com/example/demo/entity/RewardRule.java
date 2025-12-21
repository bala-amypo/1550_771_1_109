package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "reward_rules", uniqueConstraints = {@UniqueConstraint(columnNames = {"card_id", "category"})})
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private CreditCardRecord card;

    private String category;

    private String rewardType;

    @Min(0)
    private Double multiplier;

    private Boolean active = true;

    // -------- Getters & Setters --------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CreditCardRecord getCard() { return card; }
    public void setCard(CreditCardRecord card) { this.card = card; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getRewardType() { return rewardType; }
    public void setRewardType(String rewardType) { this.rewardType = rewardType; }

    public Double getMultiplier() { return multiplier; }
    public void setMultiplier(Double multiplier) { this.multiplier = multiplier; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
