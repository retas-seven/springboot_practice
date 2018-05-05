package com.tuyano.springboot.controller.regist_user;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tuyano.springboot.form.regist_user.RegistUserForm;
import com.tuyano.springboot.form.regist_user.RegistUserFormValidator;
import com.tuyano.springboot.service.regist_user.RegistUserService;

@Controller
@SessionAttributes(value = {"registUserForm"})
@RequestMapping("/regist_user")
public class RegistUserController {
	private static final Logger log = LoggerFactory.getLogger(RegistUserController.class);

	@Autowired
	RegistUserService registUserService;
	
	@Autowired
	private RegistUserFormValidator registUserFormValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(registUserFormValidator);
    }
    
	/**
	 * ユーザ登録機能Formをセッションに登録する。
	 * @return ユーザ登録機能Form
	 */
	@ModelAttribute(value = "registUserForm")
	public RegistUserForm setUpRegistUserForm() {
		log.info("Formを初期化");
	    return new RegistUserForm();
	}
	
//	/**
//	 * 初期処理。
//	 * @param model Model
//	 * @return ユーザ情報入力画面パス
//	 */
//	@RequestMapping(value="/init")
//	public String init(Model model) {
//		return "/regist_user/input";
//	}
	
	/**
	 * 仮登録確定画面へ遷移する。
	 * @param form ユーザ登録機能Form
	 * @param bindingResult BindingResult
	 * @return 仮登録確定画面パス
	 */
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String tempRegist(@Valid RegistUserForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/regist_user/input";
        }
        registUserService.tempRegist(form);
		return "/regist_user/temp_complete";
	}
	
	/**
	 * 仮登録されたユーザを本登録する。
	 * ユーザにメールで送信した認証用URLをクリックした際に実行される。
	 * @param p 認証キー（URLパラメータ）
	 * @param model Model
	 * @return 本登録確定画面パス
	 */
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String mainRegist(@RequestParam(name = "p", required = false) String p, Model model) {
		if (StringUtils.isEmpty(p)) {
			// URLパラメータなしで手打ちされた場合の想定
			return "/login";
		}
		
		// 本登録
		registUserService.mainRegist(p);
		
		return "/regist_user/complete";
	}
	
	/**
	 * ログイン画面へ戻る。
	 * @param sessionStatus SessionStatus
	 * @return ログイン画面パス
	 */
	@RequestMapping(value="/return_top", method=RequestMethod.POST)
	public String returnTop(SessionStatus sessionStatus) {
		// 後処理：セッション削除
		sessionStatus.setComplete(); 
		return "/login";
	}
}
