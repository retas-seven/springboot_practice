package com.tuyano.springboot.form.regist_user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * ユーザ登録機能Form
 */
public class RegistUserForm {
	
	@NotEmpty
	@Size(max = 50)
	@Pattern(regexp="^$|^([\"*+!.&#$|\\'\\\\%\\/0-9a-z^_`{}=?~:-]*)@(([0-9a-z-]+\\.)+[0-9a-z]{2,})$", message="{Pattern.email.message}")
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
