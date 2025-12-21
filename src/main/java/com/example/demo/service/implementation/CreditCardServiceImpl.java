package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRecordRepository cardRepo;
    private final UserProfileRepository userRepo;

    public CreditCardServiceImpl(CreditCardRecordRepository c, UserProfileRepository u) {
        this.cardRepo = c;
        this.userRepo = u;
    }

    public CreditCardRecord addCard(Long userId, CreditCardRecord card) {
        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        card.setUser(user);
        return cardRepo.save(card);
    }
}
