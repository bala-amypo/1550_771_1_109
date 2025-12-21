package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRecordRepository recommendationRepo;
    private final PurchaseIntentRecordRepository intentRepo;
    private final RewardRuleRepository ruleRepo;

    public RecommendationServiceImpl(RecommendationRecordRepository recommendationRepo,
                                     PurchaseIntentRecordRepository intentRepo,
                                     RewardRuleRepository ruleRepo) {
        this.recommendationRepo = recommendationRepo;
        this.intentRepo = intentRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public RecommendationRecord generate(Long intentId) {

        PurchaseIntentRecord intent = intentRepo.findById(intentId)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase intent not found"));

        List<RewardRule> rules = ruleRepo.findAll();

        RewardRule bestRule = null;
        double maxReward = 0;

        for (RewardRule rule : rules) {
            if (rule.getActive()
                    && rule.getCategory().equalsIgnoreCase(intent.getCategory())) {

                double reward = intent.getAmount() * rule.getMultiplier();

                if (reward > maxReward) {
                    maxReward = reward;
                    bestRule = rule;
                }
            }
        }

        if (bestRule == null) {
            throw new BadRequestException("No applicable reward rule found");
        }

        RecommendationRecord recommendation = new RecommendationRecord();
        recommendation.setUser(intent.getUser());
        recommendation.setPurchaseIntent(intent);
        recommendation.setRecommendedCard(bestRule.getCard());
        recommendation.setExpectedRewardValue(maxReward);
        recommendation.setCalculationDetailsJson(
                "Amount * Multiplier = " + intent.getAmount() + " * " + bestRule.getMultiplier()
        );

        return recommendationRepo.save(recommendation);
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recommendationRepo.findByUserId(userId);
    }
}
