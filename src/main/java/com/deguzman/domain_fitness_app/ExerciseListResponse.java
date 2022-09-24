package com.deguzman.domain_fitness_app;

import java.util.ArrayList;
import java.util.List;

import com.deguzman.DeGuzmanStuffAnywhere.model.Exercise;
import com.deguzman.DeGuzmanStuffAnywhere.model.Person;

public class ExerciseListResponse {
	
	List<Exercise> list = new ArrayList<>();
	
	int size;
	
	String message;
	
	String statusCode;
	
	String description;


	public List<Exercise> getList() {
		return list;
	}

	public void setList(List<Exercise> list) {
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
	
	
	
}
