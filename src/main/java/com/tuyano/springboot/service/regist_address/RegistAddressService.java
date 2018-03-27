package com.tuyano.springboot.service.regist_address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.dao.AddressDao;
import com.tuyano.springboot.dao.ReservationDao;
import com.tuyano.springboot.entity.Address;
import com.tuyano.springboot.entity.Reservation;
import com.tuyano.springboot.form.regist_address.InputAddressForm;

@Service
public class RegistAddressService {
	
	@Autowired
	ReservationDao reservationDao;
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
		
//		Integer maxId = addressDao.selectMaxId();
		
		Address address = new Address();
//		address.id = ++maxId;
		address.firstname = form.getFirstName();
		address.lastname = form.getLastName();
		address.mobilePhoneNumber = form.getMobilePhoneNumber();
		address.homePhoneNumber = form.getHomePhoneNumber();
		address.email = form.getEmail();
		address.zipcode = form.getZipCode();
		address.prefecture = form.getPrefecture();
		address.address = form.getAddress();
		address.buildingname = form.getBuildingName();
		
		addressDao.insert(address);
	}
}
