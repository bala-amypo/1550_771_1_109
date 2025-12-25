package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationEngineService;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public class RecommendationEngineServiceImpl implements RecommendationEngineService {
    private final PurchaseIntentRecordRepository intentRepo;
    private final UserProfileRepository userRepo;
    private final CreditCardRecordRepository cardRepo;
    private final RewardRuleRepository ruleRepo;
    private final RecommendationRecordRepository recRepo;

    public RecommendationEngineServiceImpl(PurchaseIntentRecordRepository intentRepo, UserProfileRepository userRepo, 
                                          CreditCardRecordRepository cardRepo, RewardRuleRepository ruleRepo, 
                                          RecommendationRecordRepository recRepo) {
        this.intentRepo = intentRepo;
        this.userRepo = userRepo;
        this.cardRepo = cardRepo;
        this.ruleRepo = ruleRepo;
        this.recRepo = recRepo;
    }

    public RecommendationRecord generateRecommendation(Long intentId) {
        PurchaseIntentRecord intent = intentRepo.findById(intentId)
                .orElseThrow(() -> new ResourceNotFoundException("Intent not found"));
        
        List<CreditCardRecord> activeCards = cardRepo.findActiveCardsByUser(intent.getUserId());
        if (activeCards.isEmpty()) throw new BadRequestException("No active cards available");

        CreditCardRecord bestCard = null;
        double maxReward = -1.0;

        for (CreditCardRecord card : activeCards) {
            List<RewardRule> rules = ruleRepo.findActiveRulesForCardCategory(card.getId(), intent.getCategory());
            for (RewardRule rule : rules) {
                double reward = intent.getAmount() * rule.getMultiplier();
                if (reward > maxReward) {
                    maxReward = reward;
                    bestCard = card;
                }
            }
        }

        if (bestCard == null) throw new BadRequestException("No valid reward rule found");

        RecommendationRecord rec = new RecommendationRecord();
        rec.setUserId(intent.getUserId());
        rec.setPurchaseIntentId(intentId);
        rec.setRecommendedCardId(bestCard.getId());
        rec.setExpectedRewardValue(maxReward);
        rec.setCalculationDetailsJson("{\"reward\":" + maxReward + "}");
        return recRepo.save(rec);
    }

    public List<RecommendationRecord> getRecommendationsByUser(Long userId) { return recRepo.findByUserId(userId); }
    public List<RecommendationRecord> getAllRecommendations() { return recRepo.findAll(); }
}