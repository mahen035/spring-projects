package com.training.springboot.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long projectId;
	
	private String title;
	
	public Project(String title) {
		this.title = title;
	}
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="projects")
	@JsonIgnore
	private Set<Employee> employees = new HashSet<>();

}
