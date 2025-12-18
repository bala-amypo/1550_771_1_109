package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;

@RestController
@RequestMapping("/api/credits")
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    @PostMapping
    public ResponseEntity<CreditCardRecord> createCard(@RequestBody CreditCardRecord creditCardRecord){
          CreditCardRecord card=creditCardService.addCard(creditCardRecord);
          return ResponseEntity.status(201).body(card);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCard(@PathVariable Long id,
                                               @RequestBody CreditCardRecord creditCardRecord) {
        if (creditCardService.updateCard(id, creditCardRecord) != null) {
            return ResponseEntity.status(200).body("Card Updated Successfully");
        }
        return ResponseEntity.status(404).build();
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<CreditCardRecord> getCardsByUser(@PathVariable Long userId) {
        CreditCardRecord card = creditCardService.getCardsByUser(userId);
        if (card != null) {
            return ResponseEntity.status(200).body(card);
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCardRecord> getCardById(@PathVariable Long id) {
        CreditCardRecord card = creditCardService.getCardById(id);
        if (card != null) {
            return ResponseEntity.status(200).body(card);
        }
        return ResponseEntity.status(404).build();
    }
    @GetMapping
    public List<CreditCardRecord> getAllCards() {
        return creditCardService.getAllCards();
    }
}
