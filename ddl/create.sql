CREATE DATABASE test01 CHARACTER SET = UTF8;

CREATE USER test01_user IDENTIFIED BY 'test01_user!';

GRANT ALL ON test01.* TO test01_user;

CREATE TABLE ADDRESS (
  ID                    varchar(10) NOT NULL,
  LASTNAME              VARCHAR(50),
  FIRSTNAME             VARCHAR(50),
  HOME_PHONE_NUMBER     VARCHAR(15),
  MOBILE_PHONE_NUMBER   VARCHAR(15),
  EMAIL                 VARCHAR(50),
  ZIP_CODE              VARCHAR(7),
  PREFECTURE            VARCHAR(50),
  ADDRESS               VARCHAR(50),
  BUILDING_NAME         VARCHAR(50),
  VERSION               int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (ID)
);
