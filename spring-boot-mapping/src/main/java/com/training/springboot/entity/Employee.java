package com.training.springboot.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
//@Table(name="")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long empId;
	
	private String firstName;
	private String lastName;
	
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="employees_projects",
			joinColumns= {
					@JoinColumn(name="emp_id")
			},
			inverseJoinColumns = {
					@JoinColumn(name="project_id")
			})
	Set<Project> projects = new HashSet<>();

}
