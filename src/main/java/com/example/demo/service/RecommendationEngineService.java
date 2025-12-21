package com.example.demo.service;

import com.example.demo.entity.RecommendationRecord;

public interface RecommendationService {
    RecommendationRecord generate(Long intentId);
}
