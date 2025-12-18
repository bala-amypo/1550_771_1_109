package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CreditCardRecord;

@Service
public interface CreditCardService {
    CreditCardRecord addCard(CreditCardRecord card);
    CreditCardService updateCard(Long id,CreditCardRecord updated);
    CreditCardService getCardsByUser(Long userId);
    CreditCardService getCardById(Long id);
    List<CreditCardService> getAllCards(); 
}