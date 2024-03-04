package com.ps.springboot.service;

import com.ps.springboot.model.Student;

import java.util.List;

public interface StudentService {
    public void addStudent(Student student);
   /* public List<Student> getAllStudents();

    public Student getStudentById();*/

    public Student findOldestStud();
}
