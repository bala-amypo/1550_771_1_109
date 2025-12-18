package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserProfile;

@Repository
public interface CreditCardRecordRepository extends JpaRepository<UserProfile, Long> {

    UserProfile findById(Long Id);
}
