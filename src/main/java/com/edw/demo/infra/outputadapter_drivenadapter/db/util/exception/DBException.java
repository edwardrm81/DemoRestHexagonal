package com.edw.demo.infra.outputadapter_drivenadapter.db.util.exception;

public class DBException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBException(String message) {
		super(message);
	}

	
}
