package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.service.CreditCardService;

@Service
public class CreditCardRecordImpl implements CreditCardService{
    @Autowired
    CreditCardRecordRepository creditCardRecordRepository;

    @Override
    public CreditCardRecord updatet(int id,Student UpdatedStudent){
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
