package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;

import java.util.List;
import java.util.Optional;

public interface RewardRuleRepository extends JpaRepository<RewardRule, Long> {
    List<RewardRule> findByCardId(Long cardId);
}
