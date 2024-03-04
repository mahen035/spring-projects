package com.ps.springboot.controller;

import com.ps.springboot.model.Student;
import com.ps.springboot.respository.StudentRepository;
import com.ps.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentService service;

    @Autowired
    StudentRepository repository;
    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody Student stud){
        service.addStudent(stud);
        return new ResponseEntity<>("Student Added Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/oldeststud")
    public ResponseEntity<Student> findOldest(){
        return new ResponseEntity<>(service.findOldestStud(), HttpStatus.FOUND);
    }

    /*@PostMapping("/stud")
    public Student getStudent(@RequestBody long studId){
        Optional<Student> student =repository.findById(studId);
        if(student.isPresent()){
            return student.get();
        }
        else{
            return null;
        }
    }*/
    @GetMapping("/stud")
    public Student getStudent(@RequestParam long studId){
        Optional<Student> student =repository.findById(studId);
        if(student.isPresent()){
            return student.get();
        }
        else{
            return null;
        }
    }
}
