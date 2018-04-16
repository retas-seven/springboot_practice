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
@Table(name = "temp_user_info")
public class TempUserInfo {

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    /** 認証キー */
    @Column(name = "AUTH_KEY")
    String authKey;

    /** メールアドレス */
    @Column(name = "EMAIL")
    String email;

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
     * Returns the authKey.
     * 
     * @return the authKey
     */
    public String getAuthKey() {
        return authKey;
    }

    /** 
     * Sets the authKey.
     * 
     * @param authKey the authKey
     */
    public void setAuthKey(String authKey) {
        this.authKey = authKey;
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