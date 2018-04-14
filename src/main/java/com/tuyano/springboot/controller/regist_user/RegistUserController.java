package com.tuyano.springboot.controller.regist_user;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tuyano.springboot.form.regist_user.RegistUserForm;
import com.tuyano.springboot.service.regist_user.RegistUserService;

@Controller
@SessionAttributes(value = {"registUserForm"})
@RequestMapping("/regist_user")
public class RegistUserController {
	private static final Logger log = LoggerFactory.getLogger(RegistUserController.class);

	@Autowired
	RegistUserService registUserService;
	
	@ModelAttribute(value = "registUserForm")
	public RegistUserForm setUpRegistUserForm() {
		log.info("Formを初期化");
	    return new RegistUserForm();
	}
	
	@RequestMapping(value="/init")
	public String init(Model model) {
		return "/regist_user/input";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String tempRegist(@Valid RegistUserForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/regist_user/input";
        }
        
        registUserService.tempRegist(form);
        
		return "/regist_user/complete";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String mainRegist(@RequestParam String p, Model model) {
		log.info(p);
		registUserService.mainRegist(p);
		return "/login";
	}
}
