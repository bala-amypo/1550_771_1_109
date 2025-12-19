package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "purchase_intents")
public class PurchaseIntentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserProfile userProfile;

    private Long userId;

    @Positive
    private Double amount;

    private String category;
    private String merchant;
    private LocalDateTime intentDate;

    @OneToMany(mappedBy = "purchaseIntent", cascade = CascadeType.ALL)
    private List<RecommendationRecord> recommendationRecords;

    public PurchaseIntentRecord() {
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
