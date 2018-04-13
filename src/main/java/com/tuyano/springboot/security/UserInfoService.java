package com.tuyano.springboot.security;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.dao.UserInfoDao;
import com.tuyano.springboot.entity.UserInfo;
import com.tuyano.springboot.util.ApUtil;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UserInfoDao userInfoDao;
    
	@Autowired
	HttpSession session;
	
    @Override
    public LoginUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new UsernameNotFoundException("Username is empty");
        }
        
        // ユーザ情報を取得する
        UserInfo userInfo = userInfoDao.selectByEmail(username);
        
        if (userInfo == null) {
            throw new UsernameNotFoundException("User not found for name: " + username);
        }
        
        // ユーザ情報をセッションに保持しておき、アプリ内で使用する
        ApUtil.preserveUserInfo(session, userInfo);

        return new LoginUserDetails(userInfo);
    }
}