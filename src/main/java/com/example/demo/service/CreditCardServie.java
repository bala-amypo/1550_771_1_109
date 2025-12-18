package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CreditCardRecord;

@Service
public interface CreditCardService {
    UserProfile addCard(CreditCardRecord card);
    UserProfile updateCard(Long id,CreditCardRecord updated);
    UserProfile getCardsByUser(Long userId);
    UserProfile getCardById(Long id);
    List<CreditCardService> getAllCards(); 
}