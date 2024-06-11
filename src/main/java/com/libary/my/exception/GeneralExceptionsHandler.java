package com.libary.my.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		ApiError apiError = ApiError.builder().message(ex.getMessage()).build();
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler({LibraryServiceException.class})
    public ResponseEntity<Object> handleServiceException(LibraryServiceException ex, WebRequest request) {
		ApiError apiError = ApiError.builder()
				.message(ex.getMessage())
				.build();
		return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}