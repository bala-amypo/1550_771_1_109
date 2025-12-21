package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.CreditCardService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRecordRepository cardRepo;
    private final UserProfileRepository userRepo;

    public CreditCardServiceImpl(CreditCardRecordRepository cardRepo,
                                 UserProfileRepository userRepo) {
        this.cardRepo = cardRepo;
        this.userRepo = userRepo;
    }

    @Override
    public CreditCardRecord addCard(Long userId, CreditCardRecord card) {

        if (card.getAnnualFee() < 0) {
            throw new BadRequestException("Annual fee cannot be negative");
        }

        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        card.setUser(user);
        return cardRepo.save(card);
    }
}
