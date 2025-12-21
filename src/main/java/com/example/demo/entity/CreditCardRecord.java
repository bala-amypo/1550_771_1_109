package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Min;

@Entity
public class CreditCardRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private Long userId;
    @Column(nullable=false)
    private String cardName;
    @Column(nullable=false)
    private String issuer;
    @Column(nullable=false)
    private String cardType;
    @Column(nullable=false)
    @Min(0)
    private Double annualFee;
    @Column(nullable=false)
    private String status;
    @Column(nullable=false)
    private LocalDateTime createdAt;

    public void setId(Long id) {
        this.id = id;
    }
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public void setAnnualFee(Double annualFee) {
        this.annualFee = annualFee;
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
    public String getCardName() {
        return cardName;
    }
    public String getIssuer() {
        return issuer;
    }
    public String getCardType() {
        return cardType;
    }
    public Double getAnnualFee() {
        return annualFee;
    }
    public String getStatus() {
        return status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
}