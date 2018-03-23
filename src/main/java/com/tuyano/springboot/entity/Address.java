package com.tuyano.springboot.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;

@Entity
public class Address {
	@Id
	public Integer id;

	public String firstName;
	
	public String lastName;
	
	@Column(name = "MOBILE_PHONE_NUMBER")
	public String mobilePhoneNumber;
	
	@Column(name = "HOME_PHONE_NUMBER")
	public String homePhoneNumber;
	
	public String email;
	
	public String zipCode;
	
	public String prefecture;
	
	public String address;
	
	public String buildingName;
}