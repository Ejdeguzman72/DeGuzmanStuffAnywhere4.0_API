package com.deguzman.domain_entity;

import java.util.List;

import com.deguzman.DeGuzmanStuffAnywhere.model.Vehicle;

public class VehicleListResponse {

	public List<Vehicle> list;
	
	public int size;
	
	public String message;
	
	public String statusCode;
	
	public String description;

	public List<Vehicle> getList() {
		return list;
	}

	public void setList(List<Vehicle> list) {
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
