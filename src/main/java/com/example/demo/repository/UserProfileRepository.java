package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.UserProfile;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    
    // Find by userId
    Optional<UserProfile> findByUserId(String userId);
    
    // Find by email
    Optional<UserProfile> findByEmail(String email);
    
    // Find active users
    Iterable<UserProfile> findByActiveTrue();
}
