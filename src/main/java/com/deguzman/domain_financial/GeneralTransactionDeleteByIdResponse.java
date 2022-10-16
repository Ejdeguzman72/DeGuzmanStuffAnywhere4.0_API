package com.deguzman.domain_financial;

import com.deguzman.DeGuzmanStuffAnywhere.model.AutoTransaction;
import com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction;

public class GeneralTransactionDeleteByIdResponse {

	public GeneralTransaction transaction;
	
	public Integer deleted;

	String message;

	String statusCode;

	String description;

	public GeneralTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(GeneralTransaction transaction) {
		this.transaction = transaction;
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
