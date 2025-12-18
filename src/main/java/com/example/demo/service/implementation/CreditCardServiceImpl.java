package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService{
    @Autowired
    CreditCardRecordRepository creditCardRecordRepository;

    @Override
    public CreditCardRecord addCard(CreditCardRecord card){
      return creditCardRecordRepository.save(card);
    }
    @Override
    public CreditCardRecord updateCard(Long id,CreditCardRecord updated){
        Optional<CreditCardRecord> optional = creditCardRecordRepository. findById(id);
        if(optional.isPresent()){
        CreditCardRecord existing = optional.get();
        existing.setId(updated.getid());
        existing.setUserId(updated.getuserId());
        existing.setCardName(updated.getcardName());
        existing.setIssuser(updated.getissuser());
        existing.setCardType(updated.getCardType());
        existing.setAnnualFee(updated.getAnnualFee());
        existing.setStatus(updated.getStatus());
        existing.setCreatedAt(updated.getCreatedAt());
        return creditCardRecordRepository.save(existing);
        }
        return null;
    }
    @Override
    public List<CreditCardRecord> getCardsByUser(Long userId){
      return creditCardRecordRepository.findByUserId(userId);
    }
    @Override
    public CreditCardRecord getCardById(Long id){
      Optional<CreditCardRecord> optionalCreditCardRecord = creditCardRecordRepository.findById(id);
      return optionalCreditCardRecord.orElse(null);
    }
    @Override
    public List<CreditCardRecord> getAllCards(){
       return CreditCardRecordRepository.findAll();
    }
}