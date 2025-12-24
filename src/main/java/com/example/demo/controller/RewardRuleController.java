package com.example.demo.controller;

import com.example.demo.entity.RewardRule;
import com.example.demo.service.RewardRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RewardRuleController {

    private final RewardRuleService ruleService;

    public RewardRuleController(RewardRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public RewardRule create(@RequestBody RewardRule rule) {
        return ruleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public RewardRule update(@PathVariable Long id, @RequestBody RewardRule updated) {
        return ruleService.updateRule(id, updated);
    }

    @GetMapping("/card/{cardId}")
    public List<RewardRule> getByCard(@PathVariable Long cardId) {
        return ruleService.getRulesByCard(cardId);
    }

    @GetMapping("/active")
    public List<RewardRule> getActive() {
        return ruleService.getActiveRules();
    }

    @GetMapping
    public List<RewardRule> getAll() {
        return ruleService.getAllRules();
    }
}
