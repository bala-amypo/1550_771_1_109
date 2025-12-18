package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public UserProfile createUser(UserProfile profile){
       return userProfileRepository.save(profile);
    }

    @Override
    public UserProfile getUserById(Long id){
      Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(id);
      return optionalUserProfile.orElse(null);
    }

    @Override
    public UserProfile findByUserId(String userId){
      return userProfileRepository.findByUserId(userId);
    }

    @Override
    public List<UserProfile> getAllUsers(){
       return userProfileRepository.findAll();
    }
    
    @Override
    public UserProfile updateUserStatus(Long id, boolean active) {
        Optional<UserProfile> optionalUser = userProfileRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserProfile oldUser = optionalUser.get();
            oldUser.setActive(active);
            return userProfileRepository.save(oldUser);
        }
        return null;
    }
}
