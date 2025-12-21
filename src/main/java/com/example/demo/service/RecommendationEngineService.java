package com.example.demo.service;

import com.example.demo.entity.RecommendationRecord;
import java.util.List;

public interface RecommendationService {

    RecommendationRecord generate(Long intentId);

    List<RecommendationRecord> getRecommendationsByUser(Long userId);
}
