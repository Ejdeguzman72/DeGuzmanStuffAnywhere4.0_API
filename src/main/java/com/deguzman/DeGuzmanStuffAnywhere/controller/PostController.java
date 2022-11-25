package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.service.PostsService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain_social_media.SocialMediaAddRequest;
import com.deguzman.domain_social_media.SocialMediaAddResponse;
import com.deguzman.domain_social_media.SocialMediaDeleteByIdRequest;
import com.deguzman.domain_social_media.SocialMediaDeleteByIdResponse;
import com.deguzman.domain_social_media.SocialMediaListResponse;
import com.deguzman.domain_social_media.SocialMediaSearchByUserIdRequest;

@RestController
@CrossOrigin
public class PostController {
	
	@Autowired
	private PostsService socialMediaService;
	
	@GetMapping(value = UriConstants.URI_GET_SOCIAL_MEDIA_LIST)
	public ResponseEntity<SuccessResponse<SocialMediaListResponse>> getAllPosts() {
		SocialMediaListResponse response = socialMediaService.findAllPosts();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.URI_GET_SOCIAL_MEDIA_LIST_PAGINATION)
	public ResponseEntity<Map<String, Object>> findAllPostsPagination(
			@RequestParam(required = false) String content, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return socialMediaService.findAllPostsPagination(content, page, size);
	}
	
	@GetMapping(value = UriConstants.URI_GET_SOCIAL_MEDIA_BY_ID)
	public ResponseEntity<SuccessResponse<SocialMediaListResponse>> getPostsByUser(@RequestBody SocialMediaSearchByUserIdRequest request) {
		SocialMediaListResponse response = socialMediaService.findPostsByUser(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PostMapping(value = UriConstants.URI_ADD_SOCIAL_MEDIA_INFORMATION)
	public ResponseEntity<SuccessResponse<SocialMediaAddResponse>> addPostInformation(@RequestBody SocialMediaAddRequest request) {
		SocialMediaAddResponse response = socialMediaService.addPost(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@DeleteMapping(value = UriConstants.URI_DELETE_SOCIAL_MEDIA_INFORMATION)
	public ResponseEntity<SuccessResponse<SocialMediaDeleteByIdResponse>> deletePostInformation(@RequestBody SocialMediaDeleteByIdRequest request) {
		SocialMediaDeleteByIdResponse response = socialMediaService.deletePost(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
