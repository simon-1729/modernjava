package com.modernjava.demo.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.modernjava.demo.controller.BaseController;
import com.modernjava.demo.exception.AppleExceptionDetails;

@ControllerAdvice(assignableTypes = { BaseController.class })
public class AppleExceptionControllerAdvice {

	@ExceptionHandler(ConversionFailedException.class)
	public ResponseEntity<AppleExceptionDetails> 
	handlesConversionException(HttpServletRequest request,
			ConversionFailedException e) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new AppleExceptionDetails(
				request.getRequestURI(), e.toString()));
	}
}
