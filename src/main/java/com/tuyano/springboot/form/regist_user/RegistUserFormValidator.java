package com.tuyano.springboot.form.regist_user;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tuyano.springboot.service.regist_user.RegistUserService;

@Component
public class RegistUserFormValidator implements Validator {
	private static final Logger log = LoggerFactory.getLogger(RegistUserFormValidator.class);

	@Autowired
	RegistUserService registUserService;
	
    @Override
    public boolean supports(Class<?> clazz) {
        return RegistUserForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	RegistUserForm form = (RegistUserForm) target;
        
    	validatePassword(form, errors);
    	validateExistUser(form, errors);
    }
    
    /**
     * パスワードと確認用パスワードが一致するかチェックする。
     * @param form　ユーザ登録機能Form
     * @param errors　入力チェックエラー情報
     */
    private void validatePassword(RegistUserForm form, Errors errors) {
        if (errors.hasFieldErrors("password") || errors.hasFieldErrors("confirmPassword")) {
            return;
        }
        
    	// 未入力チェック
    	if (StringUtils.isAnyEmpty(form.getPassword(), form.getConfirmPassword())) {
    		errors.rejectValue("confirmPassword", "passwordEmpty.message");
    		return;
    	}
    	
    	// パスワードの一致チェック
    	if (!StringUtils.equals(form.getPassword(), form.getConfirmPassword())) {
    		errors.rejectValue("confirmPassword", "passwordMismatch.message");
    	}
    }
    
    /**
     * 既に登録されているメールアドレスかチェックする。
     * @param form　ユーザ登録機能Form
     * @param errors　入力チェックエラー情報
     */
    private void validateExistUser(RegistUserForm form, Errors errors) {
        if (errors.hasFieldErrors("email")) {
            return;
        }
        
        // 既に登録されているメールアドレスかチェック
    	if (registUserService.existUser(form.getEmail())) {
    		errors.rejectValue("email", "alreadyRegisteredEmail.message");
    	}
    }
}
