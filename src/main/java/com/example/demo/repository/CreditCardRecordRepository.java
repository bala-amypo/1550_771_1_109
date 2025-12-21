package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;

import java.util.List;
import java.util.Optional;

public interface CreditCardRecordRepository extends JpaRepository<CreditCardRecord, Long> {
    List<CreditCardRecord> findByUserId(Long userId);
}
