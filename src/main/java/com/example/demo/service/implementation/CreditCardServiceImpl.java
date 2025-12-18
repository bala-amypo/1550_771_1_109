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
        Optional<CreditCardRecord> optionalCreditCardRecord = creditCardRecordRepository. findById(id);
        if(optionalCreditCardRecord.isPresent()){
        CreditCardRecord oldCreditCardRecord = optionalCreditCardRecord.get();
        oldCreditCardRecord.setid(UpdatedCreditCardRecord.getid());
        oldCreditCardRecord.setuserId(UpdatedCreditCardRecord.getuserId());
        oldCreditCardRecord.setcardName(UpdatedCreditCardRecord.getcardName());
        oldCreditCardRecord.setissuser(UpdatedCreditCardRecord.getissuser());
        oldCreditCardRecord.setcardType(UpdatedCreditCardRecord.getcardType());
        oldCreditCardRecord.setannualFee(UpdatedCreditCardRecord.getannualFee());
        oldCreditCardRecord.setstatus(UpdatedCreditCardRecord.getstatus());
        oldCreditCardRecord.setcreatedAt(UpdatedCreditCardRecord.getcreatedAt());
        return creditCardRecordRepository.save(oldCreditCardRecord);
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