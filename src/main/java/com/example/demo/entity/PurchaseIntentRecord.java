package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchase_intents")
public class PurchaseIntentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with UserProfile
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    @Column(nullable = false)
    @Min(value = 0, message = "Amount must be greater than 0")
    private Double amount;

    @Column(nullable = false)
    @NotBlank
    private String category;

    @Column(nullable = false)
    @NotBlank
    private String merchant;

    @Column(nullable = false)
    private LocalDateTime intentDate;

    // One-to-Many relationship with RecommendationRecord
    @OneToMany(mappedBy = "purchaseIntent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RecommendationRecord> recommendations = new HashSet<>();

    public PurchaseIntentRecord() {
    }

    @PrePersist
    protected void onCreate() {
        if (this.intentDate == null) {
            this.intentDate = LocalDateTime.now();
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public LocalDateTime getIntentDate() {
        return intentDate;
    }

    public void setIntentDate(LocalDateTime intentDate) {
        this.intentDate = intentDate;
    }

    public Set<RecommendationRecord> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(Set<RecommendationRecord> recommendations) {
        this.recommendations = recommendations;
    }
}
