package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.entity.RewardRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepository ruleRepo;
    private final CreditCardRecordRepository cardRepo;

    public RewardRuleServiceImpl(RewardRuleRepository ruleRepo,
                                 CreditCardRecordRepository cardRepo) {
        this.ruleRepo = ruleRepo;
        this.cardRepo = cardRepo;
    }

    @Override
    public RewardRule addRule(Long cardId, RewardRule rule) {

        if (rule.getMultiplier() <= 0) {
            throw new IllegalArgumentException("Multiplier must be greater than 0");
        }

        CreditCardRecord card = cardRepo.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));

        rule.setCard(card);
        return ruleRepo.save(rule);
    }

    @Override
    public List<RewardRule> getRulesByCard(Long cardId) {
        return ruleRepo.findByCardId(cardId);
    }
}
