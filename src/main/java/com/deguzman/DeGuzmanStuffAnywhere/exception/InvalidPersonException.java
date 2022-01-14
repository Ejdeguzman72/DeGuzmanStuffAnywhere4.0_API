package com.deguzman.DeGuzmanStuffAnywhere.exception;

public class InvalidPersonException extends DeGuzmanStuffAnywhereException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7697951310952132062L;

	/**
	 * Exception class to handle invalid person data 
	 * @param message
	 */
	public InvalidPersonException(String message) {
		super(message);
	}
}
