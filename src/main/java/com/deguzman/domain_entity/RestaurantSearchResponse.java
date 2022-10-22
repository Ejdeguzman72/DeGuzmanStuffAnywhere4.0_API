package com.deguzman.domain_entity;

import com.deguzman.DeGuzmanStuffAnywhere.dto.RestaurantInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant;

public class RestaurantSearchResponse {

	RestaurantInfoDTO restaurant;
	
	String message;
	
	String statusCode;
	
	String description;

	public RestaurantInfoDTO getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantInfoDTO restaurant) {
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
