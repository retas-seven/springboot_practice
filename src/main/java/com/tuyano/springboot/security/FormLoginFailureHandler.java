package com.tuyano.springboot.security;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.tuyano.springboot.aop.GenaralLogAop;


/**
 * FormLoginの認証失敗時に実行するハンドラクラス
 */
public class FormLoginFailureHandler implements
        AuthenticationFailureHandler {
	private static final Logger log = LoggerFactory.getLogger(FormLoginFailureHandler.class);

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            AuthenticationException authenticationException) throws IOException, ServletException {
    	log.info("[START] class com.tuyano.springboot.security.FormLoginFailureHandler#onAuthenticationFailure");

        if(authenticationException instanceof BadCredentialsException){
            log.info(authenticationException.getLocalizedMessage());
        }

        // ログイン画面にリダイレクトする
        String path = httpServletRequest.getContextPath() + "/?error";
        httpServletResponse.sendRedirect(path);

    	log.info("[END  ] class com.tuyano.springboot.security.FormLoginFailureHandler#onAuthenticationFailure");
    }
}