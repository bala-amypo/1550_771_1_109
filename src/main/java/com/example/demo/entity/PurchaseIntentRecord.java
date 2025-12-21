package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchase_intents")
public class PurchaseIntentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String category;
    private String merchant;
    private LocalDateTime intentDate = LocalDateTime.now();

    @ManyToOne
    private UserProfile user;

    @OneToMany(mappedBy = "purchaseIntent")
    private List<RecommendationRecord> recommendations;

    public Long getId() {
        return id;
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

    public UserProfile getUser() {
        return user;
    }

    public List<RecommendationRecord> getRecommendations() {
        return recommendations;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public void setRecommendations(List<RecommendationRecord> recommendations) {
        this.recommendations = recommendations;
    }

    

    // getters and setters

    
}
