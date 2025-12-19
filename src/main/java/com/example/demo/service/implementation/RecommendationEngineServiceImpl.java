package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.entity.RecommendationRecord;
import com.example.demo.repository.PurchaseIntentRecordRepository;
import com.example.demo.repository.RecommendationRecordRepository;
import com.example.demo.service.RecommendationEngineService;

@Service
public class RecommendationEngineServiceImpl
        implements RecommendationEngineService {

    @Autowired
    PurchaseIntentRecordRepository intentRepository;

    @Autowired
    RecommendationRecordRepository recommendationRecordRepository;

    @Override
    public RecommendationRecord generateRecommendation(Long intentId) {
        Optional<PurchaseIntentRecord> optional =intentRepository.findById(intentId);

        if (optional.isEmpty()) return null;

        PurchaseIntentRecord intent = optional.get();

        RecommendationRecord rec = new RecommendationRecord();
        rec.setPurchaseIntentId(intent.getId());
        rec.setUserId(intent.getUserId());
        rec.setRecommendedCardId(0L);
        rec.setExpectedRewardValue(intent.getAmount() * 0.05); 

        return recommendationRecordRepository.save(rec);
    }

    @Override
    public RecommendationRecord getRecommendationById(Long id) {
        return recommendationRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recommendationRecordRepository.findByUserId(userId);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recommendationRecordRepository.findAll();
    }
}
