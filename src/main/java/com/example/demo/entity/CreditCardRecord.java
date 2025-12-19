package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "credit_cards")
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @NotNull 
    private UserProfile userProfile;

    @NotNull 
    private Long userId;

    private String cardName;
    private String issuer;
    private String cardType;

    @Min(0) 
    private Double annualFee;

    @NotNull
    @Column(columnDefinition = "varchar(20) default 'ACTIVE'") // Ensure status is considered in reward calculations
    private String status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL)
    private List<RewardRule> rewardRules;

    public CreditCardRecord() {
    }

    public void setId(Long id) {
        this.id = id;
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
