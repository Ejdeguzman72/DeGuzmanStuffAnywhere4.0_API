package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.dto.PostDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Post;
import com.deguzman.DeGuzmanStuffAnywhere.service.PostsService;

@RestController
@RequestMapping("/app/posts")
@CrossOrigin
public class PostController {
	
	@Autowired
	private PostsService socialMediaService;
	
	@GetMapping("/all")
	public List<PostDTO> getAllPosts() {
		return socialMediaService.findAllPosts();
	}
	
	@GetMapping("/all-posts")
	public ResponseEntity<Map<String, Object>> findAllPostsPagination(
			@RequestParam(required = false) String content, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return socialMediaService.findAllPostsPagination(content, page, size);
	}
	
	@GetMapping("/user/{user_id}")
	public List<PostDTO> getPostsByUser(@PathVariable long user_id) {
		return socialMediaService.findPostsByUser(user_id);
	}
	
	@PostMapping("/add-post")
	public int addPostInformation(@RequestBody Post post) {
		return socialMediaService.addPost(post);
	}
	
	@DeleteMapping("/post/{post_id}")
	public int deletePostInformation(@PathVariable int post_id) {
		return socialMediaService.deletePost(post_id);
	}
}
