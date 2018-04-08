package com.tuyano.springboot.service.regist_address;

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
//		// DAOTest
//		List<Reservation> reservationList = reservationDao.selectAll();
//		for (Reservation r : reservationList) {
//			System.out.println(r.id + ", " + r.name);
//		}
//		
//		List<Address> addressList = addressDao.selectAll();
//		for (Address a : addressList) {
//			System.out.println(
//					a.id + ", " + a.firstName + ", " + a.lastName + ", " + 
//					a.homePhoneNumber + ", " + a.mobilePhoneNumber + ", " + 
//					a.email + ", " + a.zipCode + ", " + a.prefecture + ", " +  
//					a.address + ", "+ a.buildingName);
//		}
		
		// システムエラーテスト用
		if ("syserr".equals(form.getFirstName())) {
			throw new SystemException();
		}
		// アプリケーションエラーテスト用
		if ("syserr".equals(form.getFirstName())) {
			throw new ApplicationException("アプリケーションエラー発生");
		}
		
		Integer maxId = addressDao.selectMaxId();
		
		Address address = new Address();
		address.id = String.valueOf(maxId + 1);
		address.firstname = form.getFirstName();
		address.lastname = form.getLastName();
		address.mobilePhoneNumber = form.getMobilePhoneNumber();
		address.homePhoneNumber = form.getHomePhoneNumber();
		address.email = form.getEmail();
		address.zipCode = form.getZipCode();
		address.prefecture = form.getPrefecture();
		address.address = form.getAddress();
		address.buildingName = form.getBuildingName();
		
		addressDao.insert(address);
	}
}
