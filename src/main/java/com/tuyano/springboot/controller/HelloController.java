package com.tuyano.springboot.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("/login");
		return mav;
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout(ModelAndView mav) {
		mav.setViewName("/login");
		return mav;
	}

	@RequestMapping(value="/login")
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("/login");
		return mav;
	}

	@RequestMapping(value="/exec_login")
	public ModelAndView execLogin(ModelAndView mav) {
		mav.setViewName("/menu");
		return mav;
	}
	
	@RequestMapping(value="/menu")
	public ModelAndView menu(ModelAndView mav) {
		mav.setViewName("/menu");
		return mav;
	}
}
