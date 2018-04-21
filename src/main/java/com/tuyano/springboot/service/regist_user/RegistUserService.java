package com.tuyano.springboot.service.regist_user;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tuyano.springboot.dao.TempUserInfoDao;
import com.tuyano.springboot.dao.UserInfoDao;
import com.tuyano.springboot.entity.TempUserInfo;
import com.tuyano.springboot.entity.UserInfo;
import com.tuyano.springboot.exceptioon.SystemException;
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
	private TempUserInfoDao tempUserInfoDao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	/**
	 * ユーザ情報を仮登録し、登録確認メールを送信する。
	 * @param form RegistUserForm
	 */
	public void tempRegist(RegistUserForm form) {
		String authKey = null;
		
		try {
			MessageDigest salt = MessageDigest.getInstance("SHA-512");
			salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
			authKey = new String(Hex.encode(salt.digest()));
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new SystemException(e);
		}
		
		// DB登録処理
		registTempUserInfo(form, authKey);
		
		// 認証用のURLを作成する
		String url = buildUrl(authKey);
		
		// 登録確認メール送信
		// mail.propertiesの下記項目を設定してから実行する
		// ・spring.mail.username
		// ・spring.mail.password
		mailUtil.send(form.getEmail(), url);
	}
	
	/**
	 * ユーザ情報を仮登録する。
	 * @param form RegistUserForm
	 * @param authKey 認証キー
	 */
	private void registTempUserInfo(RegistUserForm form, String authKey) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encordPassword = encoder.encode(form.getPassword());
		
		TempUserInfo info = new TempUserInfo();
		info.setAuthKey(authKey);
		info.setEmail(form.getEmail());
		info.setPassword(encordPassword);
		info.setRegistDate(LocalDateTime.now());
		info.setRegistUserId("system");
		info.setUpdateDate(LocalDateTime.now());
		info.setUpdateUserId("system");
		
		tempUserInfoDao.insert(info);
	}
	
	/**
	 * 仮登録ユーザを本登録するための認証用URLを作成する。
	 * @param authKey 認証キー
	 * @return 認証用URL
	 */
	private String buildUrl(String authKey) {
		String ret = null;
		StringBuilder mainRegistUrl = new StringBuilder();
		int serverPort = req.getServerPort();
		String contextPath = req.getContextPath();
		String urlEncodeVal = ApUtil.urlEncode(authKey);
		
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
			.append(urlEncodeVal);
		
		ret = mainRegistUrl.toString();
		log.info(ret);
		
		return ret;
	}
	
	/**
	 * 仮登録されたユーザを本登録する。 
	 * @param authKey 認証キー
	 */
	public void mainRegist(String authKey) {
		TempUserInfo tempUserInfo = tempUserInfoDao.selectByAuthKey(authKey);
		
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail(tempUserInfo.getEmail());
		userInfo.setPassword(tempUserInfo.getPassword());
		userInfo.setRegistDate(LocalDateTime.now());
		userInfo.setRegistUserId("system");
		userInfo.setUpdateDate(LocalDateTime.now());
		userInfo.setUpdateUserId("system");
		userInfoDao.insert(userInfo);
	}
	
	/**
	 * ユーザの存在チェック。
	 * @param email メールアドレス
	 * @return 存在する：true, 存在しない：false
	 */
	public boolean existUser(String email) {
		UserInfo u = userInfoDao.selectByEmail(email);
		
		if (u == null) {
			return false;
		}
		
		return true;
	}
}
