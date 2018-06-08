package com.tuyano.springboot.form.address_list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tuyano.springboot.form.common.CommonAddressFormValidator;

@Component
public class AddressListFormValidator extends CommonAddressFormValidator implements Validator {
	private static final Logger log = LoggerFactory.getLogger(AddressListFormValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return AddressListForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        super.validate(target, errors);
    }
}
