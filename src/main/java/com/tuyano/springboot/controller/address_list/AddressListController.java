package com.tuyano.springboot.controller.address_list;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tuyano.springboot.entity.Address;
import com.tuyano.springboot.form.address_list.AddressListForm;
import com.tuyano.springboot.form.regist_address.InputAddressForm;
import com.tuyano.springboot.service.address_list.AddressListService;
import com.tuyano.springboot.util.ApUtil;


@Controller
@SessionAttributes(value = {"addressListForm"})
@RequestMapping("/address_list")
public class AddressListController {
	private static final Logger log = LoggerFactory.getLogger(AddressListController.class);

	@Autowired
	AddressListService addressListService;
	
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
	public String init(AddressListForm form, Model model) {
		String belongUserEmail = ApUtil.getUserInfo().getEmail();
		
		// 一覧情報を取得する
		List<Address> addressList = addressListService.searchAddress(belongUserEmail);
		form.setAddressList(addressList);
		
		return "/address_list/list";
	}

	/**
	 * 検索ボタン押下時の処理（検索条件未指定）。
	 */
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(Model model) {
		AddressListForm form = new AddressListForm();
		String belongUserEmail = ApUtil.getUserInfo().getEmail();
		
		// 一覧情報を取得する
		List<Address> addressList = addressListService.searchAddress(belongUserEmail);
		form.setAddressList(addressList);
		
		model.addAttribute(form);
		return "/address_list/list";
	}
	
	/**
	 * 検索ボタン押下時の処理。
	 */
	@RequestMapping(value="/search/{searchCondition}", method=RequestMethod.GET)
	public String search(@PathVariable String searchCondition, Model model) {
		AddressListForm form = new AddressListForm();
		String belongUserEmail = ApUtil.getUserInfo().getEmail();

		// 一覧情報を取得する
		List<Address> addressList = addressListService.searchAddress(belongUserEmail, searchCondition);
		form.setAddressList(addressList);
		
		model.addAttribute(form);
		return "/address_list/list";
	}
	
	/**
	 * 編集ボタン押下時の処理。
	 */
	@RequestMapping(value="/update/{addressId}")
	public String update(@PathVariable String addressId, AddressListForm form, Model model) {
		System.out.println("■addressId:" + addressId);
		return "/address_list/list";
	}
}
