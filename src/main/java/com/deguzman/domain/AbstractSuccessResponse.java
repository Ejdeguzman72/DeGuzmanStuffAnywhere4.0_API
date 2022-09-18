package com.deguzman.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"data"})
public abstract class AbstractSuccessResponse<R> {

	@JsonProperty("data")
	protected R data;

	public AbstractSuccessResponse() {
		// TODO Auto-generated constructor stub
	}

	public R getData() {
		return data;
	}

	public void setData(R data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AbstractSuccessResponse [data=" + data + "]";
	}
	
}
