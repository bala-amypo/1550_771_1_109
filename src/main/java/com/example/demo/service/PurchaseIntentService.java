package com.example.demo.service;

import com.example.demo.entity.UserProfile;

public interface PurchaseIntentService {
    PurchaseIntentRecord createIntent(Long userId, PurchaseIntentRecord intent);
}
