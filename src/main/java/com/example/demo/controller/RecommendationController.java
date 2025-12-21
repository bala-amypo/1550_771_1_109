package com.example.demo.controller;

import com.example.demo.entity.RecommendationRecord;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationEngineService recommendationService;

    public RecommendationController(RecommendationEngineService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping
    public RecommendationRecord generate(@RequestParam Long intentId) {
        return recommendationService.generate(intentId);
    }

    @GetMapping("/user/{userId}")
    public List<RecommendationRecord> getByUser(@PathVariable Long userId) {
        return recommendationService.getRecommendationsByUser(userId);
    }
}
