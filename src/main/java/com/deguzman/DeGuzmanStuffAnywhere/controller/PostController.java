package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.PostDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.PostDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Post;

@RestController
@RequestMapping("/app/posts")
@CrossOrigin
public class PostController {

	@Autowired
	private PostDaoImpl postDao;
	
	@GetMapping("/all")
	public List<PostDTO> getAllPosts() {
		return postDao.findAllPosts();
	}
	
	@GetMapping("/user/{user_id}")
	public List<PostDTO> getPostsByUser(@PathVariable long user_id) {
		return postDao.findPostsByUser(user_id);
	}
	
	@PostMapping("/add-post")
	public int addPostInformation(@RequestBody Post post) {
		return postDao.addPost(post);
	}
	
	@DeleteMapping("/post/{post_id}")
	public int deletePostInformation(@PathVariable int post_id) {
		return postDao.deletePost(post_id);
	}
}
