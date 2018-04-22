package com.tuyano.springboot.form.regist_address;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * アドレス登録機能Form
 */
public class InputAddressForm {
	
	@Size(max = 50)
    private String firstName;

	@Size(max = 50)
    private String lastName;

    @Pattern(regexp="[0-9\\-]*", message="{Pattern.phoneNumber.message}")
	@Size(max = 15)
    private String mobilePhoneNumber;

    @Pattern(regexp="[0-9\\-]*", message="{Pattern.phoneNumber.message}")
	@Size(max = 15)
    private String homePhoneNumber;

	@Size(max = 50)
	@Pattern(regexp="^$|^([\"*+!.&#$|\\'\\\\%\\/0-9a-z^_`{}=?~:-]*)@(([0-9a-z-]+\\.)+[0-9a-z]{2,})$", message="{Pattern.email.message}")
    private String email;

    @Pattern(regexp="^$|^\\d{7}|^\\d{3}\\-?\\d{4}$", message="{Pattern.zipCode.message}")
    private String zipCode;

	@Size(max = 50)
    private String prefecture;

	@Size(max = 50)
    private String address;

	@Size(max = 50)
    private String buildingName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Override
	public String toString() {
		return "Address [firstName=" + firstName + ", lastName=" + lastName + ", mobilePhoneNumber=" + mobilePhoneNumber
				+ ", homePhoneNumber=" + homePhoneNumber + ", email=" + email + ", zipCode=" + zipCode + ", prefecture="
				+ prefecture + ", address=" + address + ", buildingName=" + buildingName + "]";
	}
	
	
}
