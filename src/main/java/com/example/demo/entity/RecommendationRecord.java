package com.example.demo;

import java.time.LocalDateTime;

public class RecommendationRecord{
    private long id;
    private long userId;
    private long purchaseIntentId;
    private long recommendedCardId;
    private Double expectedRewardValue;
    private String calculationDetailsJson;
    private LocalDateTime recommendedAt;
}