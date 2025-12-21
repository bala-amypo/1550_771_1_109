package com.example.demo.service;

import com.example.demo.entity.UserProfile;

public interface CreditCardService {
    CreditCardRecord addCard(Long userId, CreditCardRecord card);
}
