package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.repository.PurchaseIntentRecordRepository;
import com.example.demo.service.PurchaseIntentService;

@Service
public class PurchaseIntentServiceImpl implements PurchaseIntentService {

    @Autowired
    PurchaseIntentRecordRepository purchaseIntentRecordRepository;

    @Override
    public PurchaseIntentRecord createIntent(PurchaseIntentRecord intent) {
        return purchaseIntentRecordRepository.save(intent);
    }

    @Override
    public List<PurchaseIntentRecord> getIntentsByUser(Long userId) {
        return purchaseIntentRecordRepository.findByUserId(userId);
    }

    @Override
    public PurchaseIntentRecord getIntentById(Long id) {
        Optional<PurchaseIntentRecord> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<PurchaseIntentRecord> getAllIntents() {
        return purchaseIntentRecordRepository.findAll();
    }
}
