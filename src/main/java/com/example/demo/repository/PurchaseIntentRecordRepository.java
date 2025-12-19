package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PurchaseIntentRecord;

public interface PurchaseIntentRecordRepository extends JpaRepository<PurchaseIntentRecord, Long> {

    List<PurchaseIntentRecord> findByUserId(Long userId);
}
