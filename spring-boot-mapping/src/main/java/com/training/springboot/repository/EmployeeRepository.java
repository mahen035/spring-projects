package com.training.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
