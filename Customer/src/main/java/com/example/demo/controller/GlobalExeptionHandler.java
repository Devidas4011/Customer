package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.execption.InvalidMob;
import com.example.demo.execption.InvalidName;

@ControllerAdvice
public class GlobalExeptionHandler {

	@ExceptionHandler(InvalidMob.class)
	public ResponseEntity<?> InvalidMob(InvalidMob e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidName.class)
	public ResponseEntity<?> InvalidName(InvalidName e){
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	@ExceptionHandler(com.example.demo.execption.InvalidId.class)
	public ResponseEntity<?> InvalidId(com.example.demo.execption.InvalidId e){
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	
}

