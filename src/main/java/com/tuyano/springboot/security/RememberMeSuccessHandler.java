package com.tuyano.springboot.security;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.tuyano.springboot.constant.ApConst;
import com.tuyano.springboot.entity.UserInfo;
import com.tuyano.springboot.util.ApUtil;


/**
 * remember-meのログイン成功時に実行するハンドラクラス
 */
public class RememberMeSuccessHandler implements
        AuthenticationSuccessHandler {
	private static final Logger log = LoggerFactory.getLogger(RememberMeSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(
    HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication) throws IOException, ServletException {
    	
    	LoginUserDetails loginUserDetails = (LoginUserDetails) authentication.getPrincipal();
    	UserInfo userInfo = loginUserDetails.getUserInfo();
    	
    	// ログインユーザの情報をセッションに保持し、アプリ内で使用する
    	ApUtil.preserveUserInfo(httpServletRequest.getSession(), userInfo);
    	
        // remember-meログインをした場合、メニュー画面を最初に表示する
        String path = httpServletRequest.getContextPath() + "/menu";
        httpServletResponse.sendRedirect(path);
    }
}