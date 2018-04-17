package com.tuyano.springboot.controller.regist_address;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	private static final Logger log = LoggerFactory.getLogger(RegistAddressController.class);

	@Autowired
	private RegistAddressService registAddressService;
	
	/**
	 * アドレス登録機能Formをセッションに登録する。
	 * @return アドレス登録機能Form
	 */
	@ModelAttribute(value = "inputAddressForm")
	public InputAddressForm setUpInputAddressForm() {
		log.info("アドレス登録機能Formを初期化");
	    return new InputAddressForm();
	}
	
	/**
	 * 初期処理。
	 * @param model Model
	 * @return アドレス情報入力画面パス
	 */
	@RequestMapping(value="/init")
	public String send(Model model) {
		return "/regist_address/input";
	}
	
	/**
	 * 登録内容確認へ遷移する。
	 * @param inputAddressForm アドレス登録機能Form
	 * @param bindingResult BindingResult
	 * @return 登録内容確認画面パス
	 */
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String registAddress(@Valid InputAddressForm inputAddressForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/regist_address/input";
        }
		return "/regist_address/confirm";
	}
	
	 /**
	  * アドレス情報を登録する。
	  * @param inputAddressForm アドレス登録機能Form
	  * @param model Model
	  * @return 登録完了画面パス
	  */
	@RequestMapping(value="/confirm", params="regist_button", method=RequestMethod.POST)
	public String confirmAddress(InputAddressForm inputAddressForm, Model model) {
		// アドレス情報登録処理
		registAddressService.regist(inputAddressForm);
		return "/regist_address/complete";
	}
	
	 /**
	  * アドレス情報入力画面へ戻る。
	  * @param inputAddressForm アドレス登録機能Form
	  * @param model Model
	  * @return アドレス情報入力画面パス
	  */
	@RequestMapping(value="/confirm", params="back_button", method=RequestMethod.POST)
	public String backInput(Model model) {
		return "/regist_address/input";
	}
	
	/**
	 * メニュー画面へ戻る。
	 * @param sessionStatus SessionStatus
	 * @return メニュー画面パス
	 */
	@RequestMapping(value="/complete", method=RequestMethod.POST)
	public String completeAddress(SessionStatus sessionStatus) {
		// 後処理：セッション削除
		sessionStatus.setComplete(); 
		return "/menu";
	}
}
