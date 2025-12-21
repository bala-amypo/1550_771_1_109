package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.RecommendationRecord;

import java.util.List;

@Repository
public interface RecommendationRecordRepository extends JpaRepository<RecommendationRecord, Long> {

    // Find all recommendations for a user
    List<RecommendationRecord> findByUserId(Long userId);

    // Find all recommendations for a purchase intent
    List<RecommendationRecord> findByPurchaseIntentId(Long purchaseIntentId);

    // Find all recommendations for a user and purchase intent
    List<RecommendationRecord> findByUserIdAndPurchaseIntentId(Long userId, Long purchaseIntentId);
}
