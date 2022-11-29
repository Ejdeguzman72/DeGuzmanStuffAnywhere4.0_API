package com.deguzman.domain_entity;

import com.deguzman.DeGuzmanStuffAnywhere.model.Utility;

public class UtilitySearchResponse {

	public Utility utility;
	
	String message;
	
	String statusCode;
	
	String description;

	public Utility getUtility() {
		return utility;
	}

	public void setUtility(Utility utility) {
		this.utility = utility;
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
