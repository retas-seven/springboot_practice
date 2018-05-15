package com.tuyano.springboot.form.address_list;

import java.util.List;

import com.tuyano.springboot.entity.Address;

/**
 * アドレス一覧機能Form
 */
public class AddressListForm {
	
	/** アドレス一覧情報 */
	List<Address> addressList;

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
}
