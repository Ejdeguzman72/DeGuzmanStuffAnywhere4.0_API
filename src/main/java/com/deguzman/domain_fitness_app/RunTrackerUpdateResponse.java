package com.deguzman.domain_fitness_app;

import com.deguzman.DeGuzmanStuffAnywhere.model.RunTracker;

public class RunTrackerUpdateResponse {

	public RunTracker runTracker;

	public Integer updatedCount;

	String message;

	String statusCode;

	String description;

	public RunTracker getRunTracker() {
		return runTracker;
	}

	public void setRunTracker(RunTracker runTracker) {
		this.runTracker = runTracker;
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
