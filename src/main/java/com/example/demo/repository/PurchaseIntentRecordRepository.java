package com.example.demo.service;

import com.example.demo.entity.UserProfile;

public interface RecommendationService {
    RecommendationRecord generate(Long intentId);
}

