package com.example.demo1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.model.Student;
import com.example.demo1.repository.StudentRepository;
import com.example.demo1.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    
    @Override
    public Student createStudent(Student student){
       return studentRepository.save(student);
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

package com.example.demo1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.model.Student;
import com.example.demo1.repository.StudentRepository;
import com.example.demo1.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    
    @Override
    public CreditCardRecord updateCard(Long id,Student UpdatedStudent){
        Optional<CreditCardRecord> optionalCreditCardRecord =CreditCardRecordRepository. findById(id);
        if(optionalCreditCardRecord.isPresent()){
        Student oldCreditCardRecord = optionalCreditCardRecord.get();
        oldCreditCardRecord.setUserId(UpdatedStudent.getUserId());
        oldCreditCardRecord.setCardName(UpdatedStudent.getCardName());
        oldCreditCardRecord.setIssuer(UpdatedStudent.getIssuer());
        oldCreditCardRecord.setCardType(UpdatedStudent.getCardType());
        oldCreditCardRecord.setAnnualFee(UpdatedStudent.getAnnualFee());
        oldCreditCardRecord.setStatus(UpdatedStudent.getStatus());
        oldCreditCardRecord.setCreatedAt(UpdatedStudent.getCreatedAt());
        return studentRepository.save(oldCreditCardRecord);
        }
        return null;
    }

    @Override
    public Student createStudent(Student student){
       return studentRepository.save(student);
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

