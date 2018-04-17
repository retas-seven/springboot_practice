package com.tuyano.springboot.service.regist_address;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.dao.AddressDao;
import com.tuyano.springboot.entity.Address;
import com.tuyano.springboot.entity.UserInfo;
import com.tuyano.springboot.exceptioon.ApplicationException;
import com.tuyano.springboot.exceptioon.SystemException;
import com.tuyano.springboot.form.regist_address.InputAddressForm;
import com.tuyano.springboot.util.ApUtil;

@Service
public class RegistAddressService {
	
	@Autowired
	AddressDao addressDao;

	public void regist(InputAddressForm form) {
		// システムエラーテスト用
		if ("syserr".equals(form.getFirstName())) {
			throw new SystemException();
		}
		// アプリケーションエラーテスト用
		if ("apperr".equals(form.getFirstName())) {
			throw new ApplicationException("アプリケーションエラーです。");
		}
		
		UserInfo userInfo = ApUtil.getUserInfo();
		
		Address address = new Address();
		address.setBelongUserId(userInfo.getId());
		address.setFirstname(form.getFirstName());
		address.setLastname(form.getLastName());
		address.setMobilePhoneNumber(form.getMobilePhoneNumber());
		address.setHomePhoneNumber(form.getHomePhoneNumber());
		address.setEmail(form.getEmail());
		address.setZipCode(form.getZipCode());
		address.setPrefecture(form.getPrefecture());
		address.setAddress(form.getAddress());
		address.setBuildingName(form.getBuildingName());
		address.setRegistDate(LocalDateTime.now());
		address.setRegistUserId(userInfo.getId().toString());
		address.setUpdateDate(LocalDateTime.now());
		address.setUpdateUserId(userInfo.getId().toString());
		addressDao.insert(address);
	}
}
