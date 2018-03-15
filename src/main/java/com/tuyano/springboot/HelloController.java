package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.form.InputAddressForm;

@Controller
@SessionAttributes(value = {"inputAddressForm"})
public class HelloController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(ModelAndView mav) {
		mav.setViewName("input_address");
		return mav;
	}

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
	public String completeAddress() {
		// ここで後処理をする
		return "index";
	}
}
