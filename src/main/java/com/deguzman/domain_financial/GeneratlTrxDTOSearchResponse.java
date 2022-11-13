package com.deguzman.domain_financial;

import javax.transaction.Transaction;

import com.deguzman.DeGuzmanStuffAnywhere.dto.GeneralTrxInfoDTO;

public class GeneratlTrxDTOSearchResponse {

	public GeneralTrxInfoDTO transaction;
	
	public String message;
	
	public String statusCode;
	
	public String description;

	public GeneralTrxInfoDTO getTransaction() {
		return transaction;
	}

	public void setTransaction(GeneralTrxInfoDTO transaction) {
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
