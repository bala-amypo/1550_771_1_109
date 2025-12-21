package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.RewardRule;

import java.util.List;

@Repository
public interface RewardRuleRepository extends JpaRepository<RewardRule, Long> {

    // Find all rules for a specific card
    List<RewardRule> findByCardId(Long cardId);

    // Find all active rules
    List<RewardRule> findByActiveTrue();

    // Find active rules for a specific card
    List<RewardRule> findByCardIdAndActiveTrue(Long cardId);
}
