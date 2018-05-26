package com.tuyano.springboot.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tuyano.springboot.constant.ApConst;
import com.tuyano.springboot.entity.UserInfo;
import com.tuyano.springboot.exceptioon.SystemException;

public class ApUtil {
	private static final Logger log = LoggerFactory.getLogger(ApUtil.class);

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

    /**
     * リクエストに保持したシステム日付を取得する。
     * @return システム日付
     */
    public static LocalDateTime getSysdate() {
        LocalDateTime ret = null;
        HttpServletRequest request = 
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        ret = (LocalDateTime) request.getAttribute(ApConst.REQUEST_KEY_SYSDATE);
        return ret;
	}
	
    /**
     * URLエンコード処理を行う
     * @param text URLエンコード対象文字列
     * @return URLエンコードされた文字列
     */
    public static String urlEncode(String text) {
    	String encodedResult = null;
    	
    	try {
    		encodedResult = URLEncoder.encode(text, "UTF-8");
    	} catch (UnsupportedEncodingException e) {
    		throw new SystemException(e);
    	}
    	
		log.debug("URLエンコード結果：" + encodedResult);
		return encodedResult;
    }
}
