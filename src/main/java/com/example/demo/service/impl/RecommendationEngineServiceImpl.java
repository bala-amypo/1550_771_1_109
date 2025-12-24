package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationEngineService;

import java.util.*;

public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final PurchaseIntentRecordRepository intentRepo;
    private final UserProfileRepository userRepo;
    private final CreditCardRecordRepository cardRepo;
    private final RewardRuleRepository ruleRepo;
    private final RecommendationRecordRepository recRepo;

    public RecommendationEngineServiceImpl(
            PurchaseIntentRecordRepository intentRepo,
            UserProfileRepository userRepo,
            CreditCardRecordRepository cardRepo,
            RewardRuleRepository ruleRepo,
            RecommendationRecordRepository recRepo
    ) {
        this.intentRepo = intentRepo;
        this.userRepo = userRepo;
        this.cardRepo = cardRepo;
        this.ruleRepo = ruleRepo;
        this.recRepo = recRepo;
    }

    @Override
    public RecommendationRecord generateRecommendation(Long intentId) {

        PurchaseIntentRecord intent = intentRepo.findById(intentId)
                .orElseThrow(() -> new ResourceNotFoundException("Intent not found"));

        UserProfile user = userRepo.findById(intent.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!Boolean.TRUE.equals(user.getActive()))
            throw new BadRequestException("User is not active");

        List<CreditCardRecord> activeCards = cardRepo.findActiveCardsByUser(user.getId());

        if (activeCards.isEmpty())
            throw new BadRequestException("No active cards available");

        double bestReward = -1;
        Long bestCardId = null;

        for (CreditCardRecord card : activeCards) {
            List<RewardRule> rules =
                    ruleRepo.findActiveRulesForCardCategory(card.getId(), intent.getCategory());

            for (RewardRule rule : rules) {
                double reward = intent.getAmount() * rule.getMultiplier();
                if (reward > bestReward) {
                    bestReward = reward;
                    bestCardId = card.getId();
                }
            }
        }

        if (bestCardId == null)
            throw new BadRequestException("No reward rules available");

        RecommendationRecord rec = new RecommendationRecord();
        rec.setUserId(user.getId());
        rec.setPurchaseIntentId(intent.getId());
        rec.setRecommendedCardId(bestCardId);
        rec.setExpectedRewardValue(bestReward);

        rec.setCalculationDetailsJson(
                "{\"intentAmount\":" + intent.getAmount() +
                ",\"bestReward\":" + bestReward + "}"
        );

        return recRepo.save(rec);
    }

    @Override
    public RecommendationRecord getRecommendationById(Long id) {
        return recRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recommendation not found"));
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recRepo.findByUserId(userId);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recRepo.findAll();
    }
}
