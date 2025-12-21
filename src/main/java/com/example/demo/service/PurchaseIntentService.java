package com.example.demo.service;

import com.example.demo.entity.PurchaseIntentRecord;
import java.util.List;

public interface PurchaseIntentService {

    PurchaseIntentRecord createIntent(Long userId, PurchaseIntentRecord intent);

    List<PurchaseIntentRecord> getIntentsByUser(Long userId);
}
