package com.deguzman.domain_social_media;

import com.deguzman.DeGuzmanStuffAnywhere.model.Post;

public class SocialMediaAddResponse {

	public Post post;
	
	public int recordsAdded;
	
	String message;
	
	String statusCode;
	
	String description;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getRecordsAdded() {
		return recordsAdded;
	}

	public void setRecordsAdded(int recordsAdded) {
		this.recordsAdded = recordsAdded;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
