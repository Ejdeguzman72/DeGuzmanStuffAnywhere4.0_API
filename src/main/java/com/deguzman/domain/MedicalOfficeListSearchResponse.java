package com.deguzman.domain;

import java.util.List;

import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice;

public class MedicalOfficeListSearchResponse {

	public List<MedicalOffice> vehicle;
	
	public int size;
	
	String message;
	
	String statusCode;
	
	String description;


	public List<MedicalOffice> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<MedicalOffice> vehicle) {
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
