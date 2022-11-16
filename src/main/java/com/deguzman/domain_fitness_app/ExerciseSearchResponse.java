package com.deguzman.domain_fitness_app;

import com.deguzman.DeGuzmanStuffAnywhere.dto.ExerciseInfoDTO;

public class ExerciseSearchResponse {

	public ExerciseInfoDTO exercise;
	
	String message;
	
	String statusCode;
	
	String description;

	public ExerciseInfoDTO getExercise() {
		return exercise;
	}

	public void setExercise(ExerciseInfoDTO exercise) {
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
