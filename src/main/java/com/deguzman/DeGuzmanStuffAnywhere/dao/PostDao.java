package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dto.PostDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Post;

public interface PostDao {

	public List<PostDTO> findAllPosts();
	
	public List<PostDTO> findPostsByUser(@PathVariable long user_id);
	
	public int addPost(@RequestBody Post post);
	
	public int deletePost(@PathVariable int post_id);
}
