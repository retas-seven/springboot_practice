package com.tuyano.springboot.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tuyano.springboot.exceptioon.ApplicationException;

@ControllerAdvice
public class ApplicationExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(ApplicationExceptionHandler.class);
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ApplicationException.class)
	public String handleException(Exception e) {
		log.error("アプリケーションエラー発生", e);
		return "notice";
	}
}
