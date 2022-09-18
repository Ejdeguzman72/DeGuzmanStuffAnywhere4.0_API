package com.deguzman.domain;

import java.util.List;

import com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop;

public class AutoShopSearchZipResponse {

	public List<AutoRepairShop> list;
	
	public int size;
	
	public String message;
	
	public String statusCode;
	
	public String description;

	public List<AutoRepairShop> getList() {
		return list;
	}

	public void setList(List<AutoRepairShop> list) {
		this.list = list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public AutoShopSearchZipResponse(List<AutoRepairShop> list, int size, String message, String statusCode,
			String description) {
		super();
		this.list = list;
		this.size = size;
		this.message = message;
		this.statusCode = statusCode;
		this.description = description;
	}

	public AutoShopSearchZipResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
