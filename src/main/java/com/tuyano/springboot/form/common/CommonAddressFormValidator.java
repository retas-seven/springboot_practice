package com.tuyano.springboot.form.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CommonAddressFormValidator implements Validator {
	private static final Logger log = LoggerFactory.getLogger(CommonAddressFormValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return CommonAddressForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	CommonAddressForm form = (CommonAddressForm) target;
        
        boolean isAllEmpty = StringUtils.isAllEmpty(
        		form.getFirstNameKana()
        		, form.getLastNameKana()
                , form.getFirstName()
                , form.getLastName()
                , form.getMobilePhoneNumber()
                , form.getHomePhoneNumber()
                , form.getEmail()
                , form.getZipCode()
                , form.getPrefecture() 
                , form.getAddress()
                , form.getBuildingName() 
        );
        
        if (isAllEmpty) {
            errors.reject("allEmpty.message");
        }
    }
}
