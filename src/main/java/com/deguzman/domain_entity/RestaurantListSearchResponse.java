package com.deguzman.domain_entity;

import java.util.List;

import com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant;

public class RestaurantListSearchResponse {

	List<Restaurant> restaurant;
	
	String message;
	
	String statusCode;
	
	String description;
	
	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
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
