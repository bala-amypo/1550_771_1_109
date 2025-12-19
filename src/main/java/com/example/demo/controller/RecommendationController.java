package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RecommendationRecord;
import com.example.demo.service.RecommendationEngineService;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    RecommendationEngineService service;

    @PostMapping("/generate/{intentId}")
    public ResponseEntity<RecommendationRecord> generate(
            @PathVariable Long intentId) {

        RecommendationRecord rec = service.generateRecommendation(intentId);
        if (rec != null) return ResponseEntity.status(201).body(rec);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecommendationRecord> getById(@PathVariable Long id) {
        RecommendationRecord rec = service.getRecommendationById(id);
        if (rec != null) return ResponseEntity.ok(rec);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public List<RecommendationRecord> getByUser(@PathVariable Long userId) {
        return service.getRecommendationsByUser(userId);
    }

    @GetMapping
    public List<RecommendationRecord> getAll() {
        return service.getAllRecommendations();
    }
}
