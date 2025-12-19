package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.entity.RecommendationRecord;
import com.example.demo.repository.PurchaseIntentRepository;
import com.example.demo.repository.RecommendationRecordRepository;
import com.example.demo.service.RecommendationEngineService;

@Service
public class RecommendationEngineServiceImpl
        implements RecommendationEngineService {

    @Autowired
    PurchaseIntentRepository intentRepository;

    @Autowired
    RecommendationRepository recommendationRepository;

    @Override
    public RecommendationRecord generateRecommendation(Long intentId) {

        Optional<PurchaseIntentRecord> optional =
                intentRepository.findById(intentId);

        if (optional.isEmpty()) return null;

        PurchaseIntentRecord intent = optional.get();

        RecommendationRecord rec = new RecommendationRecord();
        rec.setIntentId(intent.getId());
        rec.setUserId(intent.getUserId());
        rec.setRecommendedCard("DEFAULT_CARD");
        rec.setReward(intent.getAmount() * 0.05); // simple calculation

        return recommendationRepository.save(rec);
    }

    @Override
    public RecommendationRecord getRecommendationById(Long id) {
        return recommendationRepository.findById(id).orElse(null);
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recommendationRepository.findByUserId(userId);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recommendationRepository.findAll();
    }
}
