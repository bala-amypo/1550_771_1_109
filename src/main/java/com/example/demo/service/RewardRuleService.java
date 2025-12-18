package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RewardRule;

@Service
public interface RewardRuleService {
    RewardRule createRule(RewardRule rule);
    RewardRule updateRule(Long id,RewardRule updated)
    RewardRule getRulesByCard(Long cardId);
    RewardRule getActiveRules();
    RewardRule getAllRules();
}