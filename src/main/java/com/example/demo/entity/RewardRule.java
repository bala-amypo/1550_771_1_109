package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "reward_rules",
    uniqueConstraints = @UniqueConstraint(columnNames = {"card_id", "category"})
)
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One → CreditCardRecord
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private CreditCardRecord card;

    @NotBlank
    private String category; // Unique per card

    private String rewardType; // cashback / points

    @Min(1)
    private Double multiplier; // must be > 0

    private Boolean active = true;

    // Getters and Setters
}
