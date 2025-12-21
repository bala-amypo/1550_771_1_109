package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "purchase_intents")

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





package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "purchase_intents")
public class PurchaseIntentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One → UserProfile
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    @Min(1)
    private Double amount;

    @NotBlank
    private String category;

    private String merchant;

    private LocalDateTime intentDate;

    // One-to-Many → Recommendations
    @OneToMany(mappedBy = "purchaseIntent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecommendationRecord> recommendations;

    @PrePersist
    public void onCreate() {
        this.intentDate = LocalDateTime.now();
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
    // Getters and Setters
}
