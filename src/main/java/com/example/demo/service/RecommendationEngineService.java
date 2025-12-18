package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.RecommendationRecord;

public interface RecommendationEngineService {

    RecommendationRecord generateRecommendation(Long intentId);

    RecommendationRecord getRecommendationById(Long id);

    List<RecommendationRecord> getRecommendationsByUser(Long userId);

    List<RecommendationRecord> getAllRecommendations();
}
