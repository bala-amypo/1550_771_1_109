package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserProfile;

@Service
public interface PurchaseIntentService {
    PurchaseIntentRecord createIntent(UserProfile profile);
    PurchaseIntentRecord getUserById(Long id);
    PurchaseIntentRecord findByUserId(String userId);
    PurchaseIntentRecord getAllUsers();
}