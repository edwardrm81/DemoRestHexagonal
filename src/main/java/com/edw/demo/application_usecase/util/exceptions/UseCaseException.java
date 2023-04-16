package com.edw.demo.application_usecase.util.exceptions;

public class UseCaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UseCaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public UseCaseException(String message) {
		super(message);
	}

	
}
