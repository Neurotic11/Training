package com.example.School.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {
    @Id
    private String id;
    private int uniqueId;
    private String name;
    private String description;
    private List<String> courses;

    public Student() {
    }

    public Student(String id,Integer uniqueId, String name, String description,
                   List<String> courses) {
        super();
        this.id = id;
        this.uniqueId = uniqueId;
        this.name = name;
        this.description = description;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer id) {
        this.uniqueId = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCourses() {

        return courses;
    }
    public void setCourses( List<String>  courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return String.format(
                "Student [id=%s, name=%s, description=%s, courses=%s]", id,
                name, description, courses);
    }
}
