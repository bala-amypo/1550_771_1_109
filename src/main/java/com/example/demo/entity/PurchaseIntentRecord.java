package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "purchase_intents")
public class PurchaseIntent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserProfile userProfile;

    @Column(name = "user_id")
    private Long userId;

    private String itemName;
    private Double amount;

    private String status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "purchaseIntent", cascade = CascadeType.ALL)
    private List<RecommendationRecord> recommendations;

    public PurchaseIntent() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    public Long getUserId() {
        return userId;
    }
    public String getItemName() {
        return itemName;
    }
    public Double getAmount() {
        return amount;
    }
    public String getStatus() {
        return status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
