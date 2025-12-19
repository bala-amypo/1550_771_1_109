package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PurchaseIntentRecord;

public interface PurchaseIntentService {

    PurchaseIntentRecord createIntent(PurchaseIntentRecord intent);
    List<PurchaseIntentRecord> getIntentsByUser(Long userId);
    PurchaseIntentRecord getIntentById(Long id);
    List<PurchaseIntentRecord> getAllIntents();
}
