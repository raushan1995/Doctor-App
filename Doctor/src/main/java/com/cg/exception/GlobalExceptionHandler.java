package com.cg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

	@Value(value="${data.exception.msg}")
	
	private String msg;
	
	@ExceptionHandler(value=DoctorAlreadyExistsException.class)
	public ResponseEntity<String>DoctorAlreadyExistsException(DoctorAlreadyExistsException dae)
	{
		return new ResponseEntity<String>(msg,HttpStatus.CONFLICT);
	}
	
}
