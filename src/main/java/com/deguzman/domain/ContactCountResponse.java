package com.deguzman.domain;

public class ContactCountResponse {

	long count;

	String message;

	String statusCode;

	String description;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
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

	@Override
	public String toString() {
		return "ContactCountResponse [count=" + count + ", message=" + message + ", statusCode=" + statusCode
				+ ", description=" + description + "]";
	}

}
