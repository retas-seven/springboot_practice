package com.tuyano.springboot.form.address_list;

import java.util.List;

import com.tuyano.springboot.entity.Address;
import com.tuyano.springboot.form.common.CommonAddressForm;

/**
 * アドレス一覧機能Form
 */
public class AddressListForm extends CommonAddressForm {
	
	/** アドレス一覧情報 */
	List<Address> addressList;
	
	/** モーダルで表示したユーザのID */
	Integer targetId;

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

}
