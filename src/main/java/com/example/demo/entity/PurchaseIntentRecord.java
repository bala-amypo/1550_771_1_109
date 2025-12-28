// File: src/main/java/com/example/demo/entity/PurchaseIntentRecord.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_intent_records")
public class PurchaseIntentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String merchant;
    private String category;
    private Double amount;
    private LocalDateTime purchaseDate;

    // Optional: status, notes, etc.
    private String status;

    // Constructors
    public PurchaseIntentRecord() {}

    public PurchaseIntentRecord(Long userId, String merchant, String category, Double amount, LocalDateTime purchaseDate) {
        this.userId = userId;
        this.merchant = merchant;
        this.category = category;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.status = "NEW";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getMerchant() { return merchant; }
    public void setMerchant(String merchant) { this.merchant = merchant; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDateTime getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDateTime purchaseDate) { this.purchaseDate = purchaseDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
