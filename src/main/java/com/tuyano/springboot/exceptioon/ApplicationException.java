package com.tuyano.springboot.exceptioon;

public class ApplicationException extends RuntimeException {

	private String errMsg;

	public ApplicationException(String errMsg) {
		super();
		this.errMsg = errMsg;
	}

	private ApplicationException() {}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
