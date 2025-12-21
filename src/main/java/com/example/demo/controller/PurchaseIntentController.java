package com.example.demo.controller;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/intents")
public class PurchaseIntentController {

    private final PurchaseIntentService intentService;

    public PurchaseIntentController(PurchaseIntentService intentService) {
        this.intentService = intentService;
    }

    @PostMapping
    public PurchaseIntentRecord createIntent(@RequestParam Long userId,
                                             @RequestBody PurchaseIntentRecord intent) {
        return intentService.createIntent(userId, intent);
    }

    @GetMapping("/user/{userId}")
    public List<PurchaseIntentRecord> getIntents(@PathVariable Long userId) {
        return intentService.getIntentsByUser(userId);
    }
}
