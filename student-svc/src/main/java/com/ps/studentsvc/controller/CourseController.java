package com.ps.studentsvc.controller;

import com.ps.studentsvc.intercomm.StudentClient;
import com.ps.studentsvc.model.Course;
import com.ps.studentsvc.model.Student;
import com.ps.studentsvc.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi")
public class CourseController {
    @Autowired
    CourseRepository repository;

    @Autowired
    StudentClient studentClient;
    @PostMapping("/course")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course newCourse = repository.save(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @GetMapping("/course")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

   /* @GetMapping("/stud/{studId}")
    public Student getStudent(@PathVariable long studId){
        //A call to student service should be made
        return studentClient.getStudent(studId);
    }*/

    @GetMapping("/stud")
    public Student getStudent(@RequestParam("studId") long studId){
        //A call to student service should be made
        return studentClient.getStudent(studId);
    }
}
