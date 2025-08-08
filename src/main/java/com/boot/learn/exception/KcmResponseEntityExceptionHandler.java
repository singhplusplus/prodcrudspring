/**
 * 
 */
package com.boot.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.boot.learn.entity.ErrorMessage;

import jakarta.validation.ConstraintViolationException;

/**
 * 
 */
@RestControllerAdvice
@ResponseStatus
public class KcmResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ErrorMessage> userAlreadyExistHandler(UserAlreadyExistException exc, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE, exc.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFoundHandler(UserNotFoundException exc, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exc.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> userNotFoundHandler(ConstraintViolationException exc, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE, exc.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);
	}

}
