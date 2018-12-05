package com.example.School.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.School.model.Student;
import com.example.School.repository.StudentRepository;


@Service
public class StudentServicesImp implements StudentServices {

    private final StudentRepository repository;

    @Autowired
    public StudentServicesImp(final StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student findByName(final String Course) {
        final Student student = this.repository.findByName(Course);
        return student;
    }
//    public void delete(final Integer Course){
//        this.repository.deleteByUniqueId(Course);
//    }
}

