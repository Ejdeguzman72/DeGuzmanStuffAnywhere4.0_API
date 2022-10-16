package com.deguzman.domain_financial;

import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction;

public class MedicallTrxSearchResponse {

	public MedicalTransaction transaction;
	
	public String message;
	
	public String statusCode;
	
	public String description;

	public MedicalTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(MedicalTransaction transaction) {
		this.transaction = transaction;
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
