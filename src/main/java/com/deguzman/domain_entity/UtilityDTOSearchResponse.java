package com.deguzman.domain_entity;

import com.deguzman.DeGuzmanStuffAnywhere.dto.UtilityInfoDTO;

public class UtilityDTOSearchResponse {

	public UtilityInfoDTO utility;
	
	String message;
	
	String statusCode;
	
	String description;

	public UtilityInfoDTO getUtility() {
		return utility;
	}

	public void setUtility(UtilityInfoDTO utility) {
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
