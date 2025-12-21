package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

@Service
public class PurchaseIntentServiceImpl implements PurchaseIntentService {

    private final PurchaseIntentRecordRepository repo;
    private final UserProfileRepository userRepo;

    public PurchaseIntentServiceImpl(PurchaseIntentRecordRepository r, UserProfileRepository u) {
        this.repo = r;
        this.userRepo = u;
    }

    public PurchaseIntentRecord createIntent(Long userId, PurchaseIntentRecord intent) {
        intent.setUser(userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found")));
        return repo.save(intent);
    }
}
