package com.tuyano.springboot.form.regist_address;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class InputAddressFormValidator implements Validator {
	private static final Logger log = LoggerFactory.getLogger(InputAddressFormValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return InputAddressForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        InputAddressForm form = (InputAddressForm) target;
        
        boolean isAllEmpty = StringUtils.isAllEmpty(
                form.getFirstName()
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
