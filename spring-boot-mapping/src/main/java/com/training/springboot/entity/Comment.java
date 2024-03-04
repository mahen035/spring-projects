package com.training.springboot.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String author;
	private String content;
	//@Column(name="post_id")
	//private long postId;
	public Comment(String author, String content) {
		this.author = author;
		this.content = content;
	}
	
	@ManyToOne
	private Post post;

}
