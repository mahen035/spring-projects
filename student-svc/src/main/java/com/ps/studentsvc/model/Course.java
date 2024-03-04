package com.ps.studentsvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long courseId;

    private String courseName;
    private double courseFee;


}
