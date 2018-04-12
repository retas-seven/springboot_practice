package com.tuyano.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.handler.ApplicationExceptionHandler;

@Controller
public class HelloController {
	private static final Logger log = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

	@RequestMapping(value="/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("/login");
		return mav;
	}

//	@RequestMapping(value="/logout")
//	public ModelAndView logout(ModelAndView mav) {
//		mav.setViewName("/login");
//		return mav;
//	}

	@RequestMapping(value="/login")
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("/login");
		return mav;
	}

//	@RequestMapping(value="/exec_login")
//	public ModelAndView execLogin(ModelAndView mav) {
//		mav.setViewName("/menu");
//		return mav;
//	}
	
	@RequestMapping(value="/menu")
	public ModelAndView menu(ModelAndView mav) {
		mav.setViewName("/menu");
		return mav;
	}
	
//	@RequestMapping(value="/error_notice")
//	public ModelAndView errorNotice(ModelAndView mav) {
//		mav.setViewName("/error_notice");
//		return mav;
//	}
}
