package com.deguzman.domain_financial;

import com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction;

public class AutoTransactionUpdateResponse {

	public AutoTransaction transaction;

	public Integer updatedCount;

	String message;

	String statusCode;

	String description;

	public AutoTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(AutoTransaction transaction) {
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
