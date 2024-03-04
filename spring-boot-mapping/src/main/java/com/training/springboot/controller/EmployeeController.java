package com.training.springboot.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springboot.entity.Employee;
import com.training.springboot.entity.Project;
import com.training.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee emp) {
		Employee empObj = new Employee(emp.getFirstName(),emp.getLastName());
		for(Project project : emp.getProjects()) {
			empObj.getProjects().add(project);
		}
		repository.save(empObj);
		return "Employee Added";
	}

}
