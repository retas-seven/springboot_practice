package com.tuyano.springboot.security;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


/**
 * Spring Securityの認証失敗時に呼ばれるハンドラクラス
 */
public class RememberMeSuccessHandler implements
        AuthenticationSuccessHandler {
	private static final Logger log = LoggerFactory.getLogger(RememberMeSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(
    HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication)
                    throws IOException, ServletException {
    	
        // メニュー画面にリダイレクトする
        String path = httpServletRequest.getContextPath() + "/menu";
        httpServletResponse.sendRedirect(path);
    }
}