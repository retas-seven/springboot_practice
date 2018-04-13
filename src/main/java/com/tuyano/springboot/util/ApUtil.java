package com.tuyano.springboot.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tuyano.springboot.constant.ApConst;
import com.tuyano.springboot.entity.UserInfo;

public class ApUtil {
	
	/**
	 * アプリ内で使用するログインユーザ情報をセッションに保持する。
	 * @param session セッションオブジェクト
	 * @param userInfo ログインユーザ情報
	 */
	public static void preserveUserInfo(HttpSession session, UserInfo userInfo) {
		session.setAttribute(ApConst.SESSION_KEY_USER_INFO, userInfo);
	}

	/**
	 * セッションに保持したユーザ情報を取得する。
	 * @return ログインユーザ情報
	 */
	public static UserInfo getUserInfo() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession();
	    UserInfo userInfo = (UserInfo) session.getAttribute(ApConst.SESSION_KEY_USER_INFO);
	    return userInfo;
	}
}
