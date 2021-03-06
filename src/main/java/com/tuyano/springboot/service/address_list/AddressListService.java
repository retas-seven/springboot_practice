package com.tuyano.springboot.service.address_list;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.dao.AddressDao;
import com.tuyano.springboot.entity.Address;
import com.tuyano.springboot.form.address_list.AddressListForm;
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

	/**
	 * アドレスを削除する
	 */
	public void deleteAddress(AddressListForm form, Integer deleteTargetId) {
    	for (Address address: form.getAddressList()) {
    		if (address.getId().equals(deleteTargetId)) {
    			// アドレスを削除する
    			addressDao.delete(address);
    			break;
    		}
    	}
	}
	
	/**
	 * アドレスを更新する
	 */
	public void updateAddress(AddressListForm form) {
    	for (Address address: form.getAddressList()) {
    		if (form.getTargetId().equals(address.getId())) {
    			// アドレスを更新する
    			BeanUtils.copyProperties(form, address);
    			
    			// formとentityのプロパティ名に相違があったため、手動で値を移す（後で修正）
    			address.setFirstname(form.getFirstName());
    			address.setFirstnameKana(form.getFirstNameKana());
    			address.setLastname(form.getLastName());
    			address.setLastnameKana(form.getLastNameKana());
    			
    			address.setUpdateDate(ApUtil.getSysdate());
    			address.setUpdateUserId(ApUtil.getUserInfo().getId().toString());
    			addressDao.update(address);
    			break;
    		}
    	}
	}
}
