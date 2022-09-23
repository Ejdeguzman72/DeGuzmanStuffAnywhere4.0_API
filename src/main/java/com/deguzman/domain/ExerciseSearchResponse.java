package com.deguzman.domain;

import com.deguzman.DeGuzmanStuffAnywhere.model.Exercise;

public class ExerciseSearchResponse {

	public Exercise exercise;
	
	String message;
	
	String statusCode;
	
	String description;

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
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
