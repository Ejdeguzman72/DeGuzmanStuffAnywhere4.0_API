package com.deguzman.domain;


public class SuccessResponse<R> extends AbstractSuccessResponse<R> {

	public SuccessResponse() {
		
	}
	
	public SuccessResponse(R data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SuccessResponse [data=" + data + "]";
	}
	
}
