package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(
    name = "reward_rules",
    uniqueConstraints = @UniqueConstraint(columnNames = {"card_id", "category"})
)
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FIX: Replace cardId with relation
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private CreditCardRecord card;

    private String category;

    private String rewardType;

    @Min(1)
    private Double multiplier;

    private Boolean active = true;

    public PurchaseIntentRecord(){

    }

    
    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }
    public void setIntentDate(LocalDateTime intentDate) {
        this.intentDate = intentDate;
    }
    
    public Long getId() {
        return id;
    }
    public Long getUserId() {
        return userId;
    }
    public Double getAmount() {
        return amount;
    }
    public String getCategory() {
        return category;
    }
    public String getMerchant() {
        return merchant;
    }
    public LocalDateTime getIntentDate() {
        return intentDate;
    }
}
