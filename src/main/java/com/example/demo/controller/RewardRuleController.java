package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RewardRule;
import com.example.demo.service.RewardRuleService;

@RestController
@RequestMapping("/api/reward-rules")
public class RewardRuleController {

    @Autowired
    RewardRuleService rewardRuleService;

    // 1. createRule
    @PostMapping
    public ResponseEntity<RewardRule> createRule(@RequestBody RewardRule rule) {
        RewardRule created = rewardRuleService.createRule(rule);
        if (created != null) {
            return ResponseEntity.status(201).body(created);
        }
        return ResponseEntity.badRequest().build();
    }

    // 2. updateRule
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRule(
            @PathVariable Long id,
            @RequestBody RewardRule updated) {

        if (rewardRuleService.updateRule(id, updated) != null) {
            return ResponseEntity.ok("Rule Updated Successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // 3. getRulesByCard
    @GetMapping("/card/{cardId}")
    public ResponseEntity<List<RewardRule>> getRulesByCard(@PathVariable Long cardId) {
        List<RewardRule> rules = rewardRuleService.getRulesByCard(cardId);
        if (rules != null && !rules.isEmpty()) {
            return ResponseEntity.ok(rules);
        }
        return ResponseEntity.notFound().build();
    }

    // 4. getActiveRules
    @GetMapping("/active")
    public List<RewardRule> getActiveRules() {
        return rewardRuleService.getActiveRules();
    }

    // 5. getAllRules
    @GetMapping
    public List<RewardRule> getAllRules() {
        return rewardRuleService.getAllRules();
    }
}
