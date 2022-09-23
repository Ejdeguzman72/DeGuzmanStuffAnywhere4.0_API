package com.deguzman.domain;

import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice;

public class MedicalOfficeAddResponse {

	public MedicalOffice medicalOffice;
	
	public int recordsAdded;
	
	String message;
	
	String statusCode;
	
	String description;

	public MedicalOffice getMedicalOffice() {
		return medicalOffice;
	}

	public void setMedicalOffice(MedicalOffice medicalOffice) {
		this.medicalOffice = medicalOffice;
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
