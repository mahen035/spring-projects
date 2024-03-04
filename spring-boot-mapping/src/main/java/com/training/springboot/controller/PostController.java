package com.training.springboot.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springboot.entity.Comment;
import com.training.springboot.entity.Post;
import com.training.springboot.repository.PostRepository;


@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostRepository repository;
	
	@PostMapping("/add")
	public ResponseEntity addPost(@RequestBody Post post){
		
		Post postObj = new Post(post.getTitle(), post.getDescription());
		Set<Comment> comments = new HashSet<>();
		for(Comment comment : post.getComment()) {
			
			postObj.getComment().add(comment);
			
		}
		
		repository.save(postObj);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Post>> getPosts() {
		return new ResponseEntity(repository.findAll(), HttpStatus.OK);
	}
	
	@PutMapping("/post/{id}")
	public void updatePost(@PathVariable("id") long id, @RequestBody Post post){
		
     Optional<Post> oldPost = repository.findById(id);
		
		if(oldPost.isPresent()) {
			Post postObj = oldPost.get();
			postObj.setTitle(post.getTitle());
			postObj.setDescription(post.getDescription());
			postObj.setComment(post.getComment());
			
			repository.save(postObj);
			
			
		}
		else {
			System.out.println("No Data Found");
		}
		
		
	}

}
