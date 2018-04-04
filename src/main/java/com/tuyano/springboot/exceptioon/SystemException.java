package com.tuyano.springboot.exceptioon;

public class SystemException extends RuntimeException {

	public SystemException(Exception e) {
		super(e);
	}

	public SystemException() {
	}

}
