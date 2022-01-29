package com.deguzman.DeGuzmanStuffAnywhere.exception;

public class ResourceNotFoundException extends DeGuzmanStuffAnywhereException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -585870861123120517L;
	public static final Long serialVersionID = 1L;

	/**
	 * Exception class to handle resources that are not found within the database
	 * 
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
