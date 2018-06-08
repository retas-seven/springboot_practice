package com.tuyano.springboot.json;

import java.util.List;
import java.util.Map;

public class JsonResponse {

    private boolean validated;
    private Map<String, String> fieldErrorMessages;
//    private Map<String, String> globalErrorMessages;
    private List<String> globalErrorMessages;

	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
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
