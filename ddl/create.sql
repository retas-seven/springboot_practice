CREATE DATABASE test01 CHARACTER SET = UTF8;

CREATE USER test01_user IDENTIFIED BY 'test01_user!';

GRANT ALL ON test01.* TO test01_user;

CREATE TABLE ADDRESS (
  ID                      INT(11)     NOT NULL AUTO_INCREMENT            COMMENT 'ID'
  , LASTNAME              VARCHAR(50)                                    COMMENT '姓'
  , FIRSTNAME             VARCHAR(50)                                    COMMENT '名'
  , HOME_PHONE_NUMBER     VARCHAR(15)                                    COMMENT '電話番号'
  , MOBILE_PHONE_NUMBER   VARCHAR(15)                                    COMMENT '携帯電話番号'
  , EMAIL                 VARCHAR(50)                                    COMMENT 'メールアドレス'
  , ZIP_CODE              VARCHAR(7)                                     COMMENT '郵便番号'
  , PREFECTURE            VARCHAR(50)                                    COMMENT '都道府県'
  , ADDRESS               VARCHAR(50)                                    COMMENT '住所・番地'
  , BUILDING_NAME         VARCHAR(50)                                    COMMENT '建物名'
  , REGIST_DATE           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録年月日'
  , REGIST_USER_ID        VARCHAR(11) NOT NULL                           COMMENT '登録ユーザID'
  , UPDATE_DATE           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新年月日'
  , UPDATE_USER_ID        VARCHAR(11) NOT NULL                           COMMENT '更新ユーザID'
  , VERSION               INT(11)     NOT NULL DEFAULT '0'               COMMENT 'バージョン（楽観ロック用）'
  , PRIMARY KEY (ID)
);

CREATE TABLE USER_INFO (
  ID                      INT(11)     NOT NULL AUTO_INCREMENT            COMMENT 'ID'
  , EMAIL                 VARCHAR(50)                                    COMMENT 'メールアドレス'
  , PASSWORD              VARCHAR(100)                                   COMMENT 'パスワード'
  , REGIST_DATE           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録年月日'
  , REGIST_USER_ID        VARCHAR(11) NOT NULL                           COMMENT '登録ユーザID'
  , UPDATE_DATE           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新年月日'
  , UPDATE_USER_ID        VARCHAR(11) NOT NULL                           COMMENT '更新ユーザID'
  , VERSION               INT(11)     NOT NULL DEFAULT '0'               COMMENT 'バージョン（楽観ロック用）'
  , PRIMARY KEY (ID)
);
