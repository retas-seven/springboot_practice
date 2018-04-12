package com.tuyano.springboot.service.regist_address;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.dao.AddressDao;
import com.tuyano.springboot.entity.Address;
import com.tuyano.springboot.exceptioon.ApplicationException;
import com.tuyano.springboot.exceptioon.SystemException;
import com.tuyano.springboot.form.regist_address.InputAddressForm;

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
		
		Address address = new Address();
		address.firstname = form.getFirstName();
		address.lastname = form.getLastName();
		address.mobilePhoneNumber = form.getMobilePhoneNumber();
		address.homePhoneNumber = form.getHomePhoneNumber();
		address.email = form.getEmail();
		address.zipCode = form.getZipCode();
		address.prefecture = form.getPrefecture();
		address.address = form.getAddress();
		address.buildingName = form.getBuildingName();
		address.registDate = LocalDateTime.now();
		address.registUserId = "test"; // TODO ユーザIDを取得できるようにする
		address.updateDate = LocalDateTime.now();
		address.updateUserId = "test"; // TODO ユーザIDを取得できるようにする
		addressDao.insert(address);
	}
}
