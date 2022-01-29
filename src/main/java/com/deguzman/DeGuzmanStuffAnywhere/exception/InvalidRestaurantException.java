package com.deguzman.DeGuzmanStuffAnywhere.exception;

public class InvalidRestaurantException extends DeGuzmanStuffAnywhereException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7758440088639051785L;

	/**
	 * Exception class to handle invalid restaurant information
	 * 
	 * @param message
	 */
	public InvalidRestaurantException(String message) {
		super(message);
	}

}
