package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tuyano.springboot.form.InputAddressForm;

@Controller
@SessionAttributes(value = {"inputAddressForm"})
public class RegistAddressController {

	@RequestMapping(value="/input_address", method=RequestMethod.POST)
	public String registAddress(InputAddressForm inputAddressForm, Model model) {
		System.out.println(inputAddressForm);
		model.addAttribute("inputAddressForm", inputAddressForm);
		return "confirm_address";
	}
	
	@RequestMapping(value="/confirm_address", method=RequestMethod.POST)
	public String confirmAddress(InputAddressForm inputAddressForm, Model model) {
		System.out.println(inputAddressForm);
		
		// ここにDB登録処理を追加する
		
		return "complete_address";
	}
	
	@RequestMapping(value="/complete_address", method=RequestMethod.POST)
	public String completeAddress(SessionStatus sessionStatus) {
		// 後処理：セッション削除
		sessionStatus.setComplete(); 
		return "index";
	}
}
