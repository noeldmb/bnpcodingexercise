package com.bnpcodingexercise.exception;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@Value("${spring.application.name}")
	private String appName;

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(appName, HttpStatus.NOT_FOUND.value(), new Date(), shrinkMessage(ex.getMessage()));
		return message;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(appName, HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(),
				shrinkMessage(ex.getMessage()));
		return message;
	}

	private String shrinkMessage(String message) {

		if (message != null && message.length() > 100) {
			return message.substring(0, 100) + " ...";
		}
		return message;

	}

}
