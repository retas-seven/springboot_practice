package com.tuyano.springboot.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 * 
 */
@Entity
@Table(name = "address")
public class Address {

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer id;

    /** 姓 */
    @Column(name = "LASTNAME")
    public String lastname;

    /** 名 */
    @Column(name = "FIRSTNAME")
    public String firstname;

    /** 電話番号 */
    @Column(name = "HOME_PHONE_NUMBER")
    public String homePhoneNumber;

    /** 携帯電話番号 */
    @Column(name = "MOBILE_PHONE_NUMBER")
    public String mobilePhoneNumber;

    /** メールアドレス */
    @Column(name = "EMAIL")
    public String email;

    /** 郵便番号 */
    @Column(name = "ZIP_CODE")
    public String zipCode;

    /** 都道府県 */
    @Column(name = "PREFECTURE")
    public String prefecture;

    /** 住所・番地 */
    @Column(name = "ADDRESS")
    public String address;

    /** 建物名 */
    @Column(name = "BUILDING_NAME")
    public String buildingName;

    /** 登録年月日 */
    @Column(name = "REGIST_DATE")
    public LocalDateTime registDate;

    /** 登録ユーザID */
    @Column(name = "REGIST_USER_ID")
    public String registUserId;

    /** 更新年月日 */
    @Column(name = "UPDATE_DATE")
    public LocalDateTime updateDate;

    /** 更新ユーザID */
    @Column(name = "UPDATE_USER_ID")
    public String updateUserId;

    /** バージョン（楽観ロック用） */
    @Version
    @Column(name = "VERSION")
    public Integer version;
}