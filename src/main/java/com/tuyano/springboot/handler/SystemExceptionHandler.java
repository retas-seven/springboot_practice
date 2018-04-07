package com.tuyano.springboot.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tuyano.springboot.exceptioon.SystemException;

@ControllerAdvice
public class SystemExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(SystemExceptionHandler.class);
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SystemException.class)
	public String handleException(Exception e) {
		log.error("システムエラー発生", e);
		return "error_notice";
	}
}
