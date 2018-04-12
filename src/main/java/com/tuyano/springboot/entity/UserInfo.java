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
@Table(name = "user_info")
public class UserInfo {

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer id;

    /** メールアドレス */
    @Column(name = "EMAIL")
    public String email;

    /** パスワード */
    @Column(name = "PASSWORD")
    public String password;

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