package com.tuyano.springboot.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity
@Table(name = "address")
public class Address {

    /**  */
    @Id
    @Column(name = "ID")
    public String id;

    /**  */
    @Column(name = "LASTNAME")
    public String lastname;

    /**  */
    @Column(name = "FIRSTNAME")
    public String firstname;

    /**  */
    @Column(name = "HOME_PHONE_NUMBER")
    public String homePhoneNumber;

    /**  */
    @Column(name = "MOBILE_PHONE_NUMBER")
    public String mobilePhoneNumber;

    /**  */
    @Column(name = "EMAIL")
    public String email;

    /**  */
    @Column(name = "ZIPCODE")
    public String zipcode;

    /**  */
    @Column(name = "PREFECTURE")
    public String prefecture;

    /**  */
    @Column(name = "ADDRESS")
    public String address;

    /**  */
    @Column(name = "BUILDINGNAME")
    public String buildingname;
}