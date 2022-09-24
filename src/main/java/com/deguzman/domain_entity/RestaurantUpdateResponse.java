package com.deguzman.domain_entity;

import com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant;

public class RestaurantUpdateResponse {

	public Restaurant restaurant;
	
	public Integer updatedCount;

	public String message;

	public String statusCode;

	public String description;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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
