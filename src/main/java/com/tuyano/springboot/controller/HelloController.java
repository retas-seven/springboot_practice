package com.tuyano.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.handler.ApplicationExceptionHandler;

@Controller
public class HelloController {
	private static final Logger log = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

//	/**
//	 * TOP画面へ遷移する。
//	 * @param mav ModelAndView
//	 * @return TOP画面パス
//	 */
//	@RequestMapping(value="/")
//	public ModelAndView index(ModelAndView mav) {
////		mav.setViewName("/temp_top");
//		mav.setViewName("/index");
//		return mav;
//	}

	/**
	 * ログイン画面へ遷移する。ログインエラー時に実行される。
	 * @param model Model
	 * @return ログイン画面パス
	 */
    @GetMapping("/login_error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/login";
    }
    
	/**
	 * ログイン画面へ遷移する。
	 * @param model Model
	 * @return ログイン画面パス
	 */
	@RequestMapping(value="/login")
	public ModelAndView tempTop(ModelAndView mav) {
		mav.setViewName("/login");
		return mav;
	}
	
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
