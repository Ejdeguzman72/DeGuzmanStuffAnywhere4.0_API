package com.deguzman.DeGuzmanStuffAnywhere.exception;

public class InvalidAutoShopException extends DeGuzmanStuffAnywhereException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1684687892713579996L;

	/**
	 * Exception class that handles invalid auto repair shops
	 * 
	 * auto repair shops should exist in the database
	 * 
	 * @param message
	 */
	public InvalidAutoShopException(String message) {
		super(message);
	}
}
