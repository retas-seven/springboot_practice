package com.tuyano.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.dao.UserInfoDao;
import com.tuyano.springboot.entity.UserInfo;
import com.tuyano.springboot.security.LoginUserDetails;

@Service
public class UserInfoService implements UserDetailsService {
  @Autowired
  private UserInfoDao userInfoDao;

  @Override
  public LoginUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (username == null || "".equals(username)) {
      throw new UsernameNotFoundException("Username is empty");
    }

    UserInfo userInfo = userInfoDao.selectByEmail(username);
    if (userInfo == null) {
      throw new UsernameNotFoundException("User not found for name: " + username);
    }

    return new LoginUserDetails(userInfo);
  }
}