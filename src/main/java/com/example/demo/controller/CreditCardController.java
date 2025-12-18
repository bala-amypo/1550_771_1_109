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
    public List<CreditCardRecord> getAllcards() {
        return creditCardService.getAllcards();
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id,
                                               @RequestParam boolean active) {
        if (userProfileService.updateUserStatus(id, active) != null) {
            return ResponseEntity.status(200).body("Status Updated Successfully");
        }
        return ResponseEntity.status(404).build();
    }



    @PostMapping
    public ResponseEntity<UserProfile> createUser(@RequestBody UserProfile profile) {
        UserProfile user = userProfileService.createUser(profile);
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getStudent();
    }
    @PostMapping
    public ResponseEntity<Student> createAll(@RequestBody Student student){
          Student st=studentService.createStudent(student);
          return ResponseEntity.status(201).body(st);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id){
        Student st=studentService.getById(id);
        return ResponseEntity.status(200).body(st);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAll(@PathVariable int id){
         boolean isDeleted= studentService.deleteStudent(id);
         if(isDeleted){
            return ResponseEntity.status(201).body("Successful");
         }
         else{
            return ResponseEntity.status(404).build();
         }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> putAll(int id,@RequestBody Student student){
         if(studentService.updateStudent(id, student)!=null){
            return ResponseEntity.status(201).body("Successful");
         }
         else{
             return ResponseEntity.status(404).build();
         }
    }
}
