package com.deguzman.domain_entity;

import com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop;

public class AutoShopAddResponse {

	public AutoRepairShop autoShop;
	
	public int recordsAdded;
	
	String message;
	
	String statusCode;
	
	String description;

	public AutoRepairShop getAutoShop() {
		return autoShop;
	}

	public void setAutoShop(AutoRepairShop autoShop) {
		this.autoShop = autoShop;
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
