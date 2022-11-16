package com.deguzman.domain;

import com.deguzman.DeGuzmanStuffAnywhere.model.Books;

public class BookSearchResponse {

	public Books book;
	
	public String message;
	
	public String statusCode;
	
	public String description;


	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
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
