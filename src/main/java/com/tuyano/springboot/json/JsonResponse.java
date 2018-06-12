package com.tuyano.springboot.json;

import java.util.List;
import java.util.Map;

public class JsonResponse {

    private boolean success;
    private Map<String, String> fieldErrorMessages;
    private List<String> globalErrorMessages;
    
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Map<String, String> getFieldErrorMessages() {
		return fieldErrorMessages;
	}
	public void setFieldErrorMessages(Map<String, String> fieldErrorMessages) {
		this.fieldErrorMessages = fieldErrorMessages;
	}
	public List<String> getGlobalErrorMessages() {
		return globalErrorMessages;
	}
	public void setGlobalErrorMessages(List<String> globalErrorMessages) {
		this.globalErrorMessages = globalErrorMessages;
	}
}
