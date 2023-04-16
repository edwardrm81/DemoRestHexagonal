package com.edw.demo.infra.inputadapter_entrypoint.rest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"com.edw.demo.infra.inputadapter_entrypoint.rest"})
public class RestControllerExceptionHandler {
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<?> handleThrowableValidateExceptions(Throwable e) {
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(pd);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleExceptionValidateExceptions(Throwable e) {
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(pd);
	}
	
}
