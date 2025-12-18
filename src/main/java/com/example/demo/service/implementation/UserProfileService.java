package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entiyt.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService{
    @Autowired
    UserProfileRepository userProfileRepository;
    
    @Override
    public UserProfile createUser(UserProfile profile){
       return UserProfileRepository.save(profile);
    }
    @Override
    public UserProfile getUserById(Long id){
      Optional<UserProfile> optionalUserProfile = UserProfileRepository. findUserById(id);
      return optionalUserProfile .orElse(null);
    }
    @Override
    public UserProfile findByUserId(String userId){
      return userProfileRepository.findByUserId(userId);
    }
    @Override
    public List<Student> getStudent(){
       return studentRepository.findAll();
    }

    
    @Override
    public List<Student> getStudent(){
       return studentRepository.findAll();
    }
    @Override
    public Student getById(int id){
      Optional<Student> optionalStudent = studentRepository. findById(id);
      return optionalStudent.orElse(null);
    }
    @Override
    public boolean deleteStudent(int id){
        if(studentRepository.existsById(id)){
        studentRepository.deleteById(id);
        return true;
        }
        return false;
    }
    @Override
    public Student updateStudent(int id,Student UpdatedStudent){
        Optional<Student> optionalStudent = studentRepository. findById(id);
        if(optionalStudent.isPresent()){
        Student oldStudent = optionalStudent.get();
        oldStudent. setName(UpdatedStudent.getName());
        oldStudent.setEmail(UpdatedStudent.getEmail());
        oldStudent.setCourse(UpdatedStudent.getCourse());
        oldStudent.setAge(UpdatedStudent.getAge());
        return studentRepository.save(oldStudent);
        }
        return null;
            }
}

