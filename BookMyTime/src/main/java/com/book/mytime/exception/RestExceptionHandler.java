package com.book.mytime.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(RecordNotFoundException.class)
	protected ResponseEntity<RestApiError> handleRecordNotFoundException(RecordNotFoundException ex,WebRequest request)
	{
		RestApiError apiError = new RestApiError(HttpStatus.NOT_FOUND,request.getDescription(false),ex);
		return new ResponseEntity<RestApiError>(apiError,apiError.getStatus());
	}
	
	@ExceptionHandler(IdAlreadyExists.class)
	protected ResponseEntity<RestApiError> handleRecordNotFoundException(IdAlreadyExists ex,WebRequest request)
	{
		RestApiError apiError = new RestApiError(HttpStatus.BAD_REQUEST,request.getDescription(false),ex);
		return new ResponseEntity<RestApiError>(apiError,apiError.getStatus());
	}
}
