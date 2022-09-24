package com.deguzman.domain_entity;

import com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant;

public class RestaurantAddResponse {

	public Restaurant restaurant;
	
	public int recordsAdded;
	
	String message;
	
	String statusCode;
	
	String description;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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
