package com.deguzman.domain_social_media;

import java.util.List;

import com.deguzman.DeGuzmanStuffAnywhere.model.Post;

public class SocialMediaListResponse {

	public List<Post> list;
	
	public int size;
	
	public String message;
	
	public String statusCode;
	
	public String description;

	public List<Post> getList() {
		return list;
	}

	public void setList(List<Post> list) {
		this.list = list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
