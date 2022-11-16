package com.deguzman.domain_entity;

import com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle;

public class VehicleSearchResponse {

	public Vehicle vehicle;
	
	String message;
	
	String statusCode;
	
	String description;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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
