package com.tuyano.springboot.service.regist_user;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import com.tuyano.springboot.form.regist_user.RegistUserForm;
import com.tuyano.springboot.util.ApUtil;
import com.tuyano.springboot.util.MailUtil;

@Service
public class RegistUserService {
	private static final Logger log = LoggerFactory.getLogger(RegistUserService.class);

	@Autowired 
	private HttpServletRequest req;
	
	@Autowired
	private MailUtil mailUtil;
	
	
	@Autowired
	
	
	public void tempRegist(RegistUserForm form) {
		StringBuilder mainRegistUrl = new StringBuilder();
		int serverPort = req.getServerPort();
		String contextPath = req.getContextPath();
		//BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		//String peVal = pe.encode(form.getEmail());
		String peVal = DigestUtils.md5DigestAsHex(form.getEmail().getBytes());
		String urlEVal = ApUtil.urlEncode(peVal);
		
		//-----------------------------
		// 登録確認メールに記載するURLを構築
		//-----------------------------
		mainRegistUrl
			.append(req.getScheme())
			.append("://")
			.append(req.getServerName());
		
		if (serverPort != 80) {
			mainRegistUrl
				.append(":")
				.append(serverPort);
		}
		
		if (!StringUtils.isEmpty(contextPath)) {
			mainRegistUrl
				.append(contextPath);
		}
		
		mainRegistUrl
			.append(req.getServletPath())
			.append("?p=")
			.append(urlEVal);
		
		String url = mainRegistUrl.toString();
		log.info(url);
		
		// TODO: DB登録処理
		
		// 登録確認メール送信
		// mail.propertiesの下記項目を設定してから実行する
		// ・spring.mail.username
		// ・spring.mail.password
		mailUtil.send(form.getEmail(), url);
	}
	
	public void mainRegist(String param) {
		// TODO: DB登録処理
	}
}
