package com.training.springboot.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String title;
	private String description;
	
	public Post(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="post_id")
	private Set<Comment> comment = new HashSet<>();

}
