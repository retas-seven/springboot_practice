package com.tuyano.springboot.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.handler.ApplicationExceptionHandler;

@Controller
public class HelloController {
	private static final Logger log = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("/login");
		return mav;
	}

//  ログアウト処理はSpringSecurityで行うため不要
//	@RequestMapping(value="/logout")
//	public ModelAndView logout(ModelAndView mav) {
//		mav.setViewName("/login");
//		return mav;
//	}
	
//  ログイン処理はSpringSecurityで行うため不要
//	@RequestMapping(value="/login")
//	public ModelAndView login(ModelAndView mav) {
//		mav.setViewName("/login");
//		return mav;
//	}
	
	@RequestMapping(value="/menu")
	public ModelAndView menu(ModelAndView mav) {
		mav.setViewName("/menu");
		return mav;
	}
}
