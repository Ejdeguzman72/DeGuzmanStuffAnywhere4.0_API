package com.deguzman.DeGuzmanStuffAnywhere.exception;

public class DuplicateTitleException extends DeGuzmanStuffAnywhereException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5104092898234205115L;

	/**
	 * Exception to handle duplicate titles
	 * @param message
	 */
	public DuplicateTitleException(String message) {
		super(message);
	}
}
