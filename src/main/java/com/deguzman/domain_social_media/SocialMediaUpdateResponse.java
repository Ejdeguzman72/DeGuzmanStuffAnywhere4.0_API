package com.deguzman.domain_social_media;

import com.deguzman.DeGuzmanStuffAnywhere.model.Post;

public class SocialMediaUpdateResponse {

	public Post post;

	public Integer updatedCount;

	String message;

	String statusCode;

	String description;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Integer getUpdatedCount() {
		return updatedCount;
	}

	public void setUpdatedCount(Integer updatedCount) {
		this.updatedCount = updatedCount;
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
