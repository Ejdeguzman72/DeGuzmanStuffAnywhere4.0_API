package com.deguzman.domain;

import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice;

public class MedicalOfficeDeleteByIdResponse {

	public MedicalOffice medicalOffce;
	
	public Integer deleted;

	String message;

	String statusCode;

	String description;

	public MedicalOffice getMedicalOffce() {
		return medicalOffce;
	}

	public void setMedicalOffce(MedicalOffice medicalOffce) {
		this.medicalOffce = medicalOffce;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
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
