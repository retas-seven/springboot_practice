package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.form.RegistAddressForm;

@Controller
public class HelloController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(ModelAndView mav) {
		mav.setViewName("regist_address");
		return mav;
	}
	
	@RequestMapping(value="/regist_address", method=RequestMethod.GET)
	public ModelAndView registAddress(ModelAndView mav) {
		System.out.println(">>>regist_address");
		mav.setViewName("regist_address");
		return mav;
	}
	
	@RequestMapping(value="/regist_address", method=RequestMethod.POST)
	public String registAddress(RegistAddressForm address) {
		System.out.println(">>>regist_address:regist");
		System.out.println(address);
		return "index";
	}
}
