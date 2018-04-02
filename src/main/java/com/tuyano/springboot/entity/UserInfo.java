package com.tuyano.springboot.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 * 
 */
@Entity
@Table(name = "user_info")
public class UserInfo {

    /**  */
    @Id
    @Column(name = "ID")
    public String id;

    /**  */
    @Column(name = "EMAIL")
    public String email;

    /**  */
    @Column(name = "PASSWORD")
    public String password;

    /**  */
    @Version
    @Column(name = "VERSION")
    public Integer version;
//    
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//      List<GrantedAuthority> authorities = new ArrayList<>();
//      authorities.add(new SimpleGrantedAuthority("USER"));
//      return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//      return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//      return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//      return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//      return true;
//    }
//
//    @Override
//	public String getUsername() {
//		return email;
//	}
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", email=" + email + ", password=" + password + ", version=" + version + "]";
	}
    
    
}