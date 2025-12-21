package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.CreditCardRecord;

import java.util.List;

@Repository
public interface CreditCardRecordRepository extends JpaRepository<CreditCardRecord, Long> {

    // Find all cards by a user
    List<CreditCardRecord> findByUserId(Long userId);

    // Find cards by status
    List<CreditCardRecord> findByStatus(String status);

    // Find cards by user and status
    List<CreditCardRecord> findByUserIdAndStatus(Long userId, String status);
}
