package com.tuyano.springboot.controller.regist_address;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tuyano.springboot.form.regist_address.InputAddressForm;
import com.tuyano.springboot.service.regist_address.RegistAddressService;

@Controller
@SessionAttributes(value = {"inputAddressForm"})
@RequestMapping("/regist_address")
public class RegistAddressController {

	@Autowired
	RegistAddressService registAddressService;
	
	@RequestMapping(value="/init", method=RequestMethod.POST)
	public String send(Model model) {
		model.addAttribute("inputAddressForm", new InputAddressForm());
		return "/regist_address/input";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String registAddress(@Valid InputAddressForm inputAddressForm, BindingResult bindingResult) {
		System.out.println(inputAddressForm);

        if (bindingResult.hasErrors()) {
            return "/regist_address/input";
        }
        
		return "/regist_address/confirm";
	}
	
	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	public String confirmAddress(InputAddressForm inputAddressForm, Model model) {
		System.out.println(inputAddressForm);
		
		// アドレス情報登録処理
		registAddressService.regist(inputAddressForm);
		
		return "/regist_address/complete";
	}
	
	@RequestMapping(value="/complete", method=RequestMethod.POST)
	public String completeAddress(SessionStatus sessionStatus) {
		// 後処理：セッション削除
		sessionStatus.setComplete(); 
		return "/menu";
	}
}
