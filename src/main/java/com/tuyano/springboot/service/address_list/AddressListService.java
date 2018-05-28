package com.tuyano.springboot.service.address_list;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.dao.AddressDao;
import com.tuyano.springboot.entity.Address;
import com.tuyano.springboot.util.ApUtil;

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
	
	/**
	 * アドレス一覧を取得する
	 * @param belongUserEmail アドレス所有ユーザメールアドレス
	 * @param searchCondition 検索条件
	 * @return　アドレス一覧
	 */
	public List<Address> searchAddress(String belongUserEmail, String searchCondition) {
		List<Address> ret = new ArrayList<>();
		ret = addressDao.selectBySearchCondirion(
				belongUserEmail
				, ApUtil.convHiraganaToKataKata(searchCondition));
		return ret;
	}
	
	/**
	 * アドレス一覧を取得する
	 * @param belongUserEmail アドレス所有ユーザメールアドレス
	 * @param searchCondition 検索条件
	 * @return　アドレス一覧
	 */
	public List<Address> searchAddressIndividual(String belongUserEmail, String searchCondition) {
		List<Address> ret = new ArrayList<>();
		ret = addressDao.selectBySearchIndividual(
				belongUserEmail
				, searchCondition);
		return ret;
	}
}
