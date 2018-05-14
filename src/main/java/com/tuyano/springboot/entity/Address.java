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
    Integer id;

    /** 所属ユーザメールアドレス */
    @Column(name = "BELONG_USER_EMAIL")
    String belongUserEmail;

    /** 姓 */
    @Column(name = "LASTNAME")
    String lastname;

    /** 名 */
    @Column(name = "FIRSTNAME")
    String firstname;

    /** 電話番号 */
    @Column(name = "HOME_PHONE_NUMBER")
    String homePhoneNumber;

    /** 携帯電話番号 */
    @Column(name = "MOBILE_PHONE_NUMBER")
    String mobilePhoneNumber;

    /** メールアドレス */
    @Column(name = "EMAIL")
    String email;

    /** 郵便番号 */
    @Column(name = "ZIP_CODE")
    String zipCode;

    /** 都道府県 */
    @Column(name = "PREFECTURE")
    String prefecture;

    /** 住所・番地 */
    @Column(name = "ADDRESS")
    String address;

    /** 建物名 */
    @Column(name = "BUILDING_NAME")
    String buildingName;

    /** 登録年月日 */
    @Column(name = "REGIST_DATE")
    LocalDateTime registDate;

    /** 登録ユーザID */
    @Column(name = "REGIST_USER_ID")
    String registUserId;

    /** 更新年月日 */
    @Column(name = "UPDATE_DATE")
    LocalDateTime updateDate;

    /** 更新ユーザID */
    @Column(name = "UPDATE_USER_ID")
    String updateUserId;

    /** バージョン（楽観ロック用） */
    @Version
    @Column(name = "VERSION")
    Integer version;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * Returns the belongUserEmail.
     * 
     * @return the belongUserEmail
     */
    public String getBelongUserEmail() {
        return belongUserEmail;
    }

    /** 
     * Sets the belongUserEmail.
     * 
     * @param belongUserEmail the belongUserEmail
     */
    public void setBelongUserEmail(String belongUserEmail) {
        this.belongUserEmail = belongUserEmail;
    }

    /** 
     * Returns the lastname.
     * 
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /** 
     * Sets the lastname.
     * 
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /** 
     * Returns the firstname.
     * 
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /** 
     * Sets the firstname.
     * 
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /** 
     * Returns the homePhoneNumber.
     * 
     * @return the homePhoneNumber
     */
    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    /** 
     * Sets the homePhoneNumber.
     * 
     * @param homePhoneNumber the homePhoneNumber
     */
    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    /** 
     * Returns the mobilePhoneNumber.
     * 
     * @return the mobilePhoneNumber
     */
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    /** 
     * Sets the mobilePhoneNumber.
     * 
     * @param mobilePhoneNumber the mobilePhoneNumber
     */
    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    /** 
     * Returns the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Sets the email.
     * 
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * Returns the zipCode.
     * 
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /** 
     * Sets the zipCode.
     * 
     * @param zipCode the zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /** 
     * Returns the prefecture.
     * 
     * @return the prefecture
     */
    public String getPrefecture() {
        return prefecture;
    }

    /** 
     * Sets the prefecture.
     * 
     * @param prefecture the prefecture
     */
    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    /** 
     * Returns the address.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /** 
     * Sets the address.
     * 
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /** 
     * Returns the buildingName.
     * 
     * @return the buildingName
     */
    public String getBuildingName() {
        return buildingName;
    }

    /** 
     * Sets the buildingName.
     * 
     * @param buildingName the buildingName
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /** 
     * Returns the registDate.
     * 
     * @return the registDate
     */
    public LocalDateTime getRegistDate() {
        return registDate;
    }

    /** 
     * Sets the registDate.
     * 
     * @param registDate the registDate
     */
    public void setRegistDate(LocalDateTime registDate) {
        this.registDate = registDate;
    }

    /** 
     * Returns the registUserId.
     * 
     * @return the registUserId
     */
    public String getRegistUserId() {
        return registUserId;
    }

    /** 
     * Sets the registUserId.
     * 
     * @param registUserId the registUserId
     */
    public void setRegistUserId(String registUserId) {
        this.registUserId = registUserId;
    }

    /** 
     * Returns the updateDate.
     * 
     * @return the updateDate
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    /** 
     * Sets the updateDate.
     * 
     * @param updateDate the updateDate
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /** 
     * Returns the updateUserId.
     * 
     * @return the updateUserId
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /** 
     * Sets the updateUserId.
     * 
     * @param updateUserId the updateUserId
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    /** 
     * Returns the version.
     * 
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /** 
     * Sets the version.
     * 
     * @param version the version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}