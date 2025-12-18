package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RewardRule;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;

@Service
public class RewardRuleServiceImpl implements RewardRuleService {

    @Autowired
    RewardRuleRepository rewardRuleRepository;

    // 1. createRule → validate multiplier
    @Override
    public RewardRule createRule(RewardRule rule) {
        if (rule.getMultiplier() == null || rule.getMultiplier() <= 0) {
            return null;
        }
        return rewardRuleRepository.save(rule);
    }

    // 2. updateRule
    @Override
    public RewardRule updateRule(Long id, RewardRule updated) {
        Optional<RewardRule> optionalRule = rewardRuleRepository.findById(id);
        if (optionalRule.isPresent()) {
            RewardRule oldRule = optionalRule.get();
            oldRule.setCardId(updated.getCardId());
            oldRule.setMultiplier(updated.getMultiplier());
            oldRule.setActive(updated.isActive());
            return rewardRuleRepository.save(oldRule);
        }
        return null;
    }

    // 3. getRulesByCard
    @Override
    public List<RewardRule> getRulesByCard(Long cardId) {
        return rewardRuleRepository.findByCardId(cardId);
    }

    // 4. getActiveRules
    @Override
    public List<RewardRule> getActiveRules() {
        return rewardRuleRepository.findByActiveTrue();
    }

    // 5. getAllRules
    @Override
    public List<RewardRule> getAllRules() {
        return rewardRuleRepository.findAll();
    }
}
