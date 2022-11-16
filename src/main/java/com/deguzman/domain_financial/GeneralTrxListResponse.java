package com.deguzman.domain_financial;

import java.util.List;

import com.deguzman.DeGuzmanStuffAnywhere.dto.GeneralTrxInfoDTO;

public class GeneralTrxListResponse {

	public List<GeneralTrxInfoDTO> list;
	
	public int size;
	
	public String message;
	
	public String statusCode;
	
	public String description;

	public List<GeneralTrxInfoDTO> getList() {
		return list;
	}

	public void setList(List<GeneralTrxInfoDTO> list2) {
		this.list = list2;
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

}
