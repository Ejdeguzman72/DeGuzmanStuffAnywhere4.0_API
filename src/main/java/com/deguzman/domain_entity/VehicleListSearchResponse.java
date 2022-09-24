package com.deguzman.domain_entity;

import java.util.List;

import com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle;

public class VehicleListSearchResponse {

	public List<Vehicle> vehicle;
	
	public int size;
	
	String message;
	
	String statusCode;
	
	String description;

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
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
