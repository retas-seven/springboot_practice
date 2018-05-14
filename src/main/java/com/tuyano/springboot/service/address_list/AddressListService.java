package com.tuyano.springboot.service.address_list;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.dao.AddressDao;
import com.tuyano.springboot.entity.Address;

@Service
public class AddressListService {

	@Autowired
	private AddressDao addressDao;

	/**
	 * アドレス一覧を取得する
	 * @param belongUserEmail アドレス所有ユーザメールアドレス
	 * @return　アドレス一覧
	 */
	public List<Address> searchAddress(String belongUserEmail) {
		List<Address> ret = new ArrayList<>();
		ret = addressDao.selectByBelongUserEmail(belongUserEmail);
		return ret;
	}
}
