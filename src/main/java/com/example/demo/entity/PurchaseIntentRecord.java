package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "purchase_intents")
public class PurchaseIntentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    @Min(0)
    private Double amount;

    private String category;

    private String merchant;

    private LocalDateTime intentDate;

    @OneToMany(mappedBy = "purchaseIntent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecommendationRecord> recommendations;

    @PrePersist
    public void prePersist() {
        this.intentDate = LocalDateTime.now();
    }

    // -------- Getters & Setters --------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getMerchant() { return merchant; }
    public void setMerchant(String merchant) { this.merchant = merchant; }

    public LocalDateTime getIntentDate() { return intentDate; }
    public void setIntentDate(LocalDateTime intentDate) { this.intentDate = intentDate; }

    public List<RecommendationRecord> getRecommendations() { return recommendations; }
    public void setRecommendations(List<RecommendationRecord> recommendations) { this.recommendations = recommendations; }
}
