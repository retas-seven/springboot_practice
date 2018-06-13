package com.tuyano.springboot.controller.address_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tuyano.springboot.entity.Address;
import com.tuyano.springboot.form.address_list.AddressListForm;
import com.tuyano.springboot.form.address_list.AddressListFormValidator;
import com.tuyano.springboot.json.JsonResponse;
import com.tuyano.springboot.service.address_list.AddressListService;
import com.tuyano.springboot.util.ApUtil;


@Controller
@SessionAttributes(value = {"addressListForm"})
@RequestMapping("/address_list")
public class AddressListController {
	private static final Logger log = LoggerFactory.getLogger(AddressListController.class);

	@Autowired
	AddressListService addressListService;
	
	@Autowired
	private AddressListFormValidator addressListFormValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(addressListFormValidator);
    }
    
    @Autowired
	MessageSource messageSource;
    
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
	 * 検索ボタン押下時の処理。
	 */
	@RequestMapping(value="/search_individual/{searchCondition}", method=RequestMethod.GET)
	public String searchIndividual(@PathVariable String searchCondition, Model model) {
		AddressListForm form = new AddressListForm();
		String belongUserEmail = ApUtil.getUserInfo().getEmail();

		// 一覧情報を取得する
		List<Address> addressList = addressListService.searchAddressIndividual(belongUserEmail, searchCondition);
		form.setAddressList(addressList);
		
		model.addAttribute(form);
		return "/address_list/list";
	}
	
//	/**
//	 * 編集ボタン押下時の処理。
//	 */
//	@RequestMapping(value="/update/{addressId}")
//	public String update(@PathVariable String addressId, AddressListForm form, Model model) {
//		System.out.println("■addressId:" + addressId);
//		return "/address_list/list";
//	}
	
	/**
	 * 削除ボタン押下時の処理。
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteAddress(AddressListForm form, Integer deleteTargetId) {
		JsonResponse jsonResponse = new JsonResponse();
		List<String> globalErrorList = new ArrayList<>();
		
    	//----------------------------------------------------
    	// アドレスを削除する
    	//----------------------------------------------------
		try {
			addressListService.deleteAddress(form, deleteTargetId);
			jsonResponse.setSuccess(true);
		} catch (OptimisticLockingFailureException oe) {
			System.out.println("■" + oe.getMessage());
			// 排他エラー発生時
			globalErrorList.add(
					messageSource.getMessage("addresslist.optimisticLockingFailure.message", null, Locale.getDefault()));
		}

        jsonResponse.setGlobalErrorMessages(globalErrorList);
		return jsonResponse;
	}
	
	
	/**
	 * （モーダルの）更新ボタン押下時の処理。
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateAddress(@Valid AddressListForm form, BindingResult bindingResult) {
		JsonResponse jsonResponse = new JsonResponse();
    	List<String> globalErrorList = new ArrayList<>();
		
        if (bindingResult.hasErrors()) {
        	//----------------------------------------------------
        	// 入力チェックエラーがある場合、モーダル画面にエラーメッセージを表示する
        	//----------------------------------------------------
        	Map<String, String> fieldErrorMap = new HashMap<>();
        	
            // 全体のエラーメッセージを設定
	        for (ObjectError err: bindingResult.getGlobalErrors()) {
	        	  globalErrorList.add(messageSource.getMessage(err.getCode(), null, Locale.getDefault()));
	        }
            
        	// フィールド個別のエラーメッセージを設定
            for (FieldError err: bindingResult.getFieldErrors()) {
                fieldErrorMap.put(err.getField(), err.getDefaultMessage());
            }
            jsonResponse.setFieldErrorMessages(fieldErrorMap);
            
        } else {
        	//----------------------------------------------------
        	// 入力チェックエラーがない場合、アドレスを更新する
        	//----------------------------------------------------
    		try {
    			addressListService.updateAddress(form);
    			jsonResponse.setSuccess(true);
    		} catch (OptimisticLockingFailureException oe) {
    			// 排他エラー発生時
    			globalErrorList.add(
    					messageSource.getMessage("addresslist.optimisticLockingFailure.message", null, Locale.getDefault()));
    		}
        }

        jsonResponse.setGlobalErrorMessages(globalErrorList);
		return jsonResponse;
	}
}
