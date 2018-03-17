package com.tuyano.springboot.controller.regist_address;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tuyano.springboot.form.regist_address.InputAddressForm;

@Controller
@SessionAttributes(value = {"inputAddressForm"})
@RequestMapping("/regist_address")
public class RegistAddressController {

	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String registAddress(InputAddressForm inputAddressForm, Model model) {
		System.out.println(inputAddressForm);
		model.addAttribute("inputAddressForm", inputAddressForm);
		return "/regist_address/confirm";
	}
	
	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	public String confirmAddress(InputAddressForm inputAddressForm, Model model) {
		System.out.println(inputAddressForm);
		
		// ここにDB登録処理を追加する
		
		return "/regist_address/complete";
	}
	
	@RequestMapping(value="/complete", method=RequestMethod.POST)
	public String completeAddress(SessionStatus sessionStatus) {
		// 後処理：セッション削除
		sessionStatus.setComplete(); 
		return "/index";
	}
}
