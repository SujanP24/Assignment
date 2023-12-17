package com.assignment.demo.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.demo.constants.Constants;
import com.assignment.demo.utility.DemoResponse;

@ControllerAdvice
public class ExceptionControllerAdvice {
	@ExceptionHandler(CommonCustomException.class)
	public ResponseEntity<DemoResponse> commonCustomException(CommonCustomException e) {
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED.value()).body(new DemoResponse(
				Constants.PRE_CONDITION_FAILED, Constants.FAILURE, e.getMessage(), new ArrayList<>(), null));

	}

}
