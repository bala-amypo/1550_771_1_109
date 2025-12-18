package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entity.CreditCardRecord;

public interface CreditCardService {
    CreditCardRecord addCard(CreditCardRecord card);
    CreditCardRecord updateCard(Long id,CreditCardRecord updated);
    List<CreditCardRecord> getCardsByUser(Long userId);
    CreditCardRecord getCardById(Long id);
    List<CreditCardRecord> getAllCards(); 
}