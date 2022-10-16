package com.deguzman.domain_financial;

import com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction;

public class GeneralTransactionAddResponse {

	public GeneralTransaction transaction;
	
	public int recordsAdded;
	
	String message;
	
	String statusCode;
	
	String description;

	public GeneralTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(GeneralTransaction transaction) {
		this.transaction = transaction;
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
