package com.tuyano.springboot.controller.address_list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tuyano.springboot.form.address_list.AddressListForm;


@Controller
@SessionAttributes(value = {"addressListForm"})
@RequestMapping("/address_list")
public class AddressListController {
	private static final Logger log = LoggerFactory.getLogger(AddressListController.class);

	/**
	 * アドレス一覧機能Formをセッションに登録する。
	 * @return アドレス一覧機能Form
	 */
	@ModelAttribute(value = "addressListForm")
	public AddressListForm setUpAddressListForm() {
		log.info("アドレス登録機能Formを初期化");
	    return new AddressListForm();
	}
	
	/**
	 * 初期処理。
	 * @param model Model
	 * @return アドレス一覧画面パス
	 */
	@RequestMapping(value="/init")
	public String init(Model model) {
		return "/address_list/list";
	}
}
