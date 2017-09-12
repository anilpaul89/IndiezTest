package com.indiez.test.controller;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.indiez.test.exception.ApiException;
import com.indiez.test.response.BaseResponse;
import com.indiez.test.response.ErrorDescription;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<BaseResponse> sendErrorDetails(ApiException e) {
		BaseResponse response = new BaseResponse();
		ErrorDescription description = new ErrorDescription();
		description.setMessage(e.getMessage());
		response.setError(description);
		ResponseEntity<BaseResponse> entity = new ResponseEntity<BaseResponse>(
				response, HttpStatus.SERVICE_UNAVAILABLE);
		return entity;

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<BaseResponse> sendErrorDetails(MethodArgumentNotValidException  e) {
		BaseResponse response = new BaseResponse();
		ErrorDescription description = new ErrorDescription();
		String errorMsg = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(e.getMessage());
		description.setMessage(errorMsg);
		response.setError(description);
		ResponseEntity<BaseResponse> entity = new ResponseEntity<BaseResponse>(
				response, HttpStatus.BAD_REQUEST);
		return entity;

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<BaseResponse> sendErrorDetail(Exception  e) {
		BaseResponse response = new BaseResponse();
		ErrorDescription description = new ErrorDescription();
		description.setMessage(e.getMessage());
		response.setError(description);
		ResponseEntity<BaseResponse> entity = new ResponseEntity<BaseResponse>(
				response, HttpStatus.SERVICE_UNAVAILABLE);
		return entity;

	}

}
