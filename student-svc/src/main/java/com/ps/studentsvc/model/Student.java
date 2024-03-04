package com.ps.studentsvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    //@Column(name="Stud_Id")
    private long studId;
    private String studName;
    private int age;
    private String grade;
    public Student(String studName, int age, String grade){
        this.studName = studName;
        this.age = age;
        this.grade = grade;
    }
}
