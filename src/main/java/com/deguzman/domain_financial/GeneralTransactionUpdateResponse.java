package com.deguzman.domain_financial;

import com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction;

public class GeneralTransactionUpdateResponse {

	public GeneralTransaction transaction;

	public Integer updatedCount;

	String message;

	String statusCode;

	String description;

	public GeneralTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(GeneralTransaction transaction) {
		this.transaction = transaction;
	}

	public Integer getUpdatedCount() {
		return updatedCount;
	}

	public void setUpdatedCount(Integer updatedCount) {
		this.updatedCount = updatedCount;
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
