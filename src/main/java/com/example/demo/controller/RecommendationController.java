package com.example.demo.controller;

import com.example.demo.entity.RecommendationRecord;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationEngineService recService;

    public RecommendationController(RecommendationEngineService recService) {
        this.recService = recService;
    }

    @PostMapping("/{intentId}")
    public RecommendationRecord generate(@PathVariable Long intentId) {
        return recService.generateRecommendation(intentId);
    }

    @GetMapping("/{id}")
    public RecommendationRecord get(@PathVariable Long id) {
        return recService.getRecommendationById(id);
    }

    @GetMapping("/user/{userId}")
    public List<RecommendationRecord> getByUser(@PathVariable Long userId) {
        return recService.getRecommendationsByUser(userId);
    }

    @GetMapping
    public List<RecommendationRecord> getAll() {
        return recService.getAllRecommendations();
    }
}
