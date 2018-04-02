package com.tuyano.springboot.security;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


/**
 * Spring Securityの認証失敗時に呼ばれるハンドラクラス
 */
public class GeneralAuthenticationFailureHandler implements
        AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            AuthenticationException authenticationException)
                    throws IOException, ServletException {

        if(authenticationException instanceof BadCredentialsException){
            System.out.println(authenticationException.getLocalizedMessage());
        }

        // ログイン画面にリダイレクトする
        String path = httpServletRequest.getContextPath() + "/?error";
        httpServletResponse.sendRedirect(path);
    }
}