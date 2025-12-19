package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.service.PurchaseIntentService;

@RestController
@RequestMapping("/api/intents")
public class PurchaseIntentController {

    @Autowired
    PurchaseIntentService service;

    @PostMapping
    public ResponseEntity<PurchaseIntentRecord> createIntent(
            @RequestBody PurchaseIntentRecord intent) {
        return ResponseEntity.status(201).body(service.createIntent(intent));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PurchaseIntentRecord>> getByUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(service.getIntentsByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseIntentRecord> getById(@PathVariable Long id) {
        PurchaseIntentRecord intent = service.getIntentById(id);
        if (intent != null) return ResponseEntity.ok(intent);
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<PurchaseIntentRecord> getAll() {
        return service.getAllIntents();
    }
}
