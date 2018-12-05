package com.example.School.controller;

import java.util.ArrayList;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import com.example.School.model.Student;
import com.example.School.repository.StudentRepository;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/create",method = RequestMethod.POST)

    public Student create(@RequestBody Map<String,Object> studentMap){
        System.out.println("Hi");
       Student student = new Student();
        student.setName((String) studentMap.get("name"));
        student.setUniqueId(Integer.parseInt((String) studentMap.get("uniqueId")));
        student.setDescription((String) studentMap.get("description"));
        System.out.println(studentMap.get("courses"));
        student.setCourses((ArrayList<String>) studentMap.get("courses"));
        studentRepository.save(student);
        return student;
    }

    @RequestMapping(value = "/read/{studentId}", method = RequestMethod.GET)
    public Student read(@PathVariable Integer studentId,String name) {
        System.out.println(studentId);
        Student student = studentRepository.findByUniqueId(studentId);
     //   student.setName((String) studentId.get("name"));
      // student.setDescription((String) studentId.get("description"));
      //  student.setName(studentId.get("name"));
     //  studentRepository.save(student);
//        Map<Student, String> dataMap = new HashMap<Student, String>();
//        dataMap.put("message", "Name found successfully");
//        dataMap.put("status", "1");
//        dataMap.put("student", student);
        return student;
   }

    @RequestMapping(value = "/update/{studentId}",method = RequestMethod.PUT)
     public void update(@RequestBody Map<String,Object> studentMap,@PathVariable Integer studentId){
        Student student = studentRepository.findByUniqueId(studentId);
        student.setName((String) studentMap.get("name"));
        student.setDescription((String) studentMap.get("description"));
        student.setCourses((ArrayList<String>) studentMap.get("courses"));
        studentRepository.save(student);
//        Map<Student, String> dataMap = new HashMap<Student, String>();
//        dataMap.put("message", "Name found successfully");
//        dataMap.put("status", "1");
//        dataMap.put("student", student);
    }

    @RequestMapping(value = "/delete/{studentId}",method = RequestMethod.DELETE)
    public void delete(@PathVariable String studentId) {
        System.out.println(studentId);
        studentRepository.deleteById(new ObjectId(studentId));
//        Map<Student, String> dataMap = new HashMap<Student, String>();
//        dataMap.put("message", "Name found successfully");
//        dataMap.put("status", "1");
    }
}
