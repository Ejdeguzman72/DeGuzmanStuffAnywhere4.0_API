package com.deguzman.domain_entity;

import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice;

public class MedicalOfficeSearchResponse {

	public MedicalOffice medicalOffice;
	
	public String message;
	
	public String statusCode;
	
	public String description;

	public MedicalOffice getMedicalOffice() {
		return medicalOffice;
	}

	public void setMedicalOffice(MedicalOffice medicalOffice) {
		this.medicalOffice = medicalOffice;
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
