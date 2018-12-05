package com.example.School.repository;

import com.example.School.model.Student;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface StudentRepository extends MongoRepository <Student, ObjectId>{
    Student findByUniqueId(Integer id);
    Student findByName(String name);
    void deleteById(ObjectId studentId );
}


