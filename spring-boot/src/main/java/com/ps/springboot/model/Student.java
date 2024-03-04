package com.ps.springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
//@Table(name="Stud")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
