package com.tuyano.springboot.form.regist_user;

import javax.validation.constraints.Size;


public class RegistUserForm {
	
	@Size(max = 50)
    private String email;
    
	@Size(max = 100)
    private String password;

	@Size(max = 100)
    private String confirmPassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
