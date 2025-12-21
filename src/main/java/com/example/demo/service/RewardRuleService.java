package com.example.demo.service;

import com.example.demo.entity.RewardRule;
import java.util.List;

public interface RewardRuleService {

    RewardRule addRule(Long cardId, RewardRule rule);

    List<RewardRule> getRulesByCard(Long cardId);
}
