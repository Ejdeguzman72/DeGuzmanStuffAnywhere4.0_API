package com.deguzman.domain;

import com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant;

public class RestaurantSearchResponse {

	Restaurant restaurant;
	
	String message;
	
	String statusCode;
	
	String description;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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
