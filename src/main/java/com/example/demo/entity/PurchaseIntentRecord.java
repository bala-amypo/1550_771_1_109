package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PurchaseIntentRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private Long userId;
    @Column(nullable=false)
    @Min(0)
    private Double amount;
    @Column(nullable=false)
    private String category;
    @Column(nullable=false)
    private String merchant;
    @Column(nullable=false)
    private LocalDateTime intentDate;


    
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