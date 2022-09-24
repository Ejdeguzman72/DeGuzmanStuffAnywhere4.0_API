package com.deguzman.domain_fitness_app;

import com.deguzman.DeGuzmanStuffAnywhere.model.Exercise;

public class ExerciseDeleteByIdResponse {

	public Exercise exercise;
	
	public Integer deleted;

	String message;

	String statusCode;

	String description;

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
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
