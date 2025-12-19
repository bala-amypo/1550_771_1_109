package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "reward_rules", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"card_id", "category"})
})
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with CreditCardRecord
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    private CreditCardRecord creditCard;

    @Column(nullable = false)
    @NotBlank
    private String category;

    @Column(name = "reward_type", nullable = false)
    @NotBlank
    private String rewardType;

    @Column(nullable = false)
    @Min(value = 0, message = "Price multiplier must be > 0")
    private Double multiplier;

    @Column(nullable = false)
    private Boolean active = true;

    public RewardRule() {
    }

    @PrePersist
    protected void onCreate() {
        if (this.active == null) {
            this.active = true;
        }
    }

    // Getters and Setters

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
        if (multiplier == null || multiplier <= 0) {
            throw new IllegalArgumentException("Price multiplier must be > 0");
        }
        this.multiplier = multiplier;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
