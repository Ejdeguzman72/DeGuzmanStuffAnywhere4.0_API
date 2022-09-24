package com.deguzman.domain_fitness_app;

import com.deguzman.DeGuzmanStuffAnywhere.model.Exercise;

public class ExerciseUpdateResponse {

	public Exercise exercise;

	public Integer updatedCount;

	String message;

	String statusCode;

	String description;

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
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
