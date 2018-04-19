package com.tuyano.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.handler.ApplicationExceptionHandler;

@Controller
public class HelloController {
	private static final Logger log = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

	/**
	 * ログイン画面へ遷移する。
	 * @param mav ModelAndView
	 * @return ログイン画面パス
	 */
	@RequestMapping(value="/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("/login");
		return mav;
	}

	/**
	 * ログイン画面へ遷移する（SpringSecurityによるログアウト処理完了後に実行される）。
	 * @param mav
	 * @return
	 */
	@RequestMapping(value="/spring_security_logout_success")
	public ModelAndView springSecurityLogoutSuccess(ModelAndView mav) {
		// リダイレクトしてブラウザのURL表示をクリーンにする
		mav.setViewName("redirect:/login");
		return mav;
	}
	
//  ログイン処理はSpringSecurityで行うため不要
//	@RequestMapping(value="/login")
//	public ModelAndView login(ModelAndView mav) {
//		mav.setViewName("/login");
//		return mav;
//	}
	
	/**
	 * メニュー画面へ遷移する。
	 * @param mav ModelAndView
	 * @return メニュー画面パス
	 */
	@RequestMapping(value="/menu")
	public ModelAndView menu(ModelAndView mav) {
		mav.setViewName("/menu");
		return mav;
	}
}
