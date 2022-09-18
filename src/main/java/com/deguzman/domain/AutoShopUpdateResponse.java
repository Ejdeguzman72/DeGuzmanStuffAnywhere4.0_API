package com.deguzman.domain;

import com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop;

public class AutoShopUpdateResponse {

	public AutoRepairShop autoShop;
	
	public Integer updatedCount;

	public String message;

	public String statusCode;

	public String description;


	public AutoRepairShop getAutoShop() {
		return autoShop;
	}

	public void setAutoShop(AutoRepairShop autoShop) {
		this.autoShop = autoShop;
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
