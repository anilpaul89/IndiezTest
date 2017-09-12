package com.indiez.test.exception;

public class ApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiException(String message) {
		super();
		this.message = message;
	}

}
