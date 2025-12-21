package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.PurchaseIntentRecord;

import java.util.List;

@Repository
public interface PurchaseIntentRecordRepository extends JpaRepository<PurchaseIntentRecord, Long> {

    // Find all purchase intents by a user
    List<PurchaseIntentRecord> findByUserId(Long userId);

    // Find all purchase intents by category
    List<PurchaseIntentRecord> findByCategory(String category);

    // Find all purchase intents by user and category
    List<PurchaseIntentRecord> findByUserIdAndCategory(Long userId, String category);
}
