package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RewardRuleRepository;

@Repository
public interface RewardRuleRepository extends JpaRepository<RewardRule, Long> {

    List<RewardRule> findById(Long id);
}
