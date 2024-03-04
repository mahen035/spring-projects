package com.training.springboot.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String firstName;
	private String lastName;
	private int age;
	private char gender;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id", referencedColumnName = "id")
	private Address address;
	
	public User(String firstName,String lastName, int age, char gender) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
		this.gender=gender;
	}

}
