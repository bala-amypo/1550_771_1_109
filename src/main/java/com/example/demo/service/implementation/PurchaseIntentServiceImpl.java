package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PurchaseIntentRecordRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.PurchaseIntentService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PurchaseIntentServiceImpl implements PurchaseIntentService {

    private final PurchaseIntentRecordRepository intentRepo;
    private final UserProfileRepository userRepo;

    public PurchaseIntentServiceImpl(PurchaseIntentRecordRepository intentRepo,
                                     UserProfileRepository userRepo) {
        this.intentRepo = intentRepo;
        this.userRepo = userRepo;
    }

    @Override
    public PurchaseIntentRecord createIntent(Long userId, PurchaseIntentRecord intent) {

        if (intent.getAmount() <= 0) {
            throw new BadRequestException("Amount must be greater than zero");
        }

        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        intent.setUser(user);
        return intentRepo.save(intent);
    }

    @Override
    public List<PurchaseIntentRecord> getIntentsByUser(Long userId) {
        return intentRepo.findByUserId(userId);
    }
}
