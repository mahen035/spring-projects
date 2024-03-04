package com.ps.studentsvc.intercomm;

import com.ps.studentsvc.model.Student;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient(name="student", url="http://localhost:8081")
@FeignClient("student-service")
@RibbonClient(name="student-service")
public interface StudentClient {
    /*@PostMapping(value="/api/v1/stud", consumes ="application/json")
    Student getStudent(@RequestBody long studId);*/

    @GetMapping(value="/api/v1/stud", consumes = "application/json")
    Student getStudent(@RequestParam long studId);
}

//http://localhost:8081/api/v1/stud

// Discovery Server: Netflix Eureka Server
