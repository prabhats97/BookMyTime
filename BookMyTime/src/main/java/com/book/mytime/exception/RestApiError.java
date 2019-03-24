package com.book.mytime.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RestApiError {
	
	private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String path;
	   private String debugMessage;

	   private RestApiError() {
	       timestamp = LocalDateTime.now();
	   }

	   RestApiError(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   RestApiError(HttpStatus status, String path,Throwable ex){
	       this();
	       this.status = status;
	       this.path = path;
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	   
	   

}
