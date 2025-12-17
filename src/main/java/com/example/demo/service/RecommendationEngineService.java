package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.entity.UserProfile;

@Service
public interface RecommendationEngineService {
    RecommendationRecord createIntent(PurchaseIntentRecord intent)
    RecommendationRecord getIntentsbyUser(Long userId)
    RecommendationRecord getIntentById(Long id);
    RecommendationRecord getAllIntents();
}