package com.tuyano.springboot.security;

import org.springframework.security.core.authority.AuthorityUtils;

import com.tuyano.springboot.entity.UserInfo;

public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 1L;
	
	private final UserInfo userInfo;
	
    public LoginUserDetails(UserInfo userInfo) {
        // スーパークラスのユーザーID、パスワードに値をセットする
        // 実際の認証はスーパークラスのユーザーID、パスワードで行われる
        super(userInfo.getEmail(), userInfo.getPassword(),
                AuthorityUtils.createAuthorityList("USER"));
        this.userInfo = userInfo;
    }


    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
      return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public boolean isEnabled() {
      return true;
    }

    @Override
	public String getUsername() {
		return userInfo.getEmail();
	}

    @Override
	public String getPassword() {
		return userInfo.getPassword();
	}

    public UserInfo getUserInfo() {
        return userInfo;
    }
    
    public Integer getId() {
    	return userInfo.getId();
    }
}
