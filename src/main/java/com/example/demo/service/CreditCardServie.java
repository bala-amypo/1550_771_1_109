package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserProfile;

@Service
public interface UserProfileService {
    UserProfile addCard(CreditCardRecord card);
    UserProfile updateCard(Long id,CreditCardRecord updated);
    UserProfile GetCardByUser(String userId);
    UserProfile getAllUsers();
    UserProfile updateUserStatus(Long id,boolean active);
}