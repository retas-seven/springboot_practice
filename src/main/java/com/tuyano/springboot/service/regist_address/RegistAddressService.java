package com.tuyano.springboot.service.regist_address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.dao.ReservationDao;
import com.tuyano.springboot.entity.Reservation;
import com.tuyano.springboot.form.regist_address.InputAddressForm;

@Service
public class RegistAddressService {
	
	@Autowired
	ReservationDao reservationDao;

	public void regist(InputAddressForm inputAddressForm) {
		// DAOTest
		List<Reservation> reservationList = reservationDao.selectAll();
		
		for (Reservation r : reservationList) {
			System.out.println(r.id + ", " + r.name);
		}
	}
}
