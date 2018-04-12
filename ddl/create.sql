CREATE DATABASE test01 CHARACTER SET = UTF8;

CREATE USER test01_user IDENTIFIED BY 'test01_user!';

GRANT ALL ON test01.* TO test01_user;

CREATE TABLE ADDRESS (
  ID                      INT(11)     NOT NULL AUTO_INCREMENT            COMMENT 'ID'
  , LASTNAME              VARCHAR(50)                                    COMMENT '��'
  , FIRSTNAME             VARCHAR(50)                                    COMMENT '��'
  , HOME_PHONE_NUMBER     VARCHAR(15)                                    COMMENT '�d�b�ԍ�'
  , MOBILE_PHONE_NUMBER   VARCHAR(15)                                    COMMENT '�g�ѓd�b�ԍ�'
  , EMAIL                 VARCHAR(50)                                    COMMENT '���[���A�h���X'
  , ZIP_CODE              VARCHAR(7)                                     COMMENT '�X�֔ԍ�'
  , PREFECTURE            VARCHAR(50)                                    COMMENT '�s���{��'
  , ADDRESS               VARCHAR(50)                                    COMMENT '�Z���E�Ԓn'
  , BUILDING_NAME         VARCHAR(50)                                    COMMENT '������'
  , REGIST_DATE           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '�o�^�N����'
  , REGIST_USER_ID        VARCHAR(11) NOT NULL                           COMMENT '�o�^���[�UID'
  , UPDATE_DATE           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '�X�V�N����'
  , UPDATE_USER_ID        VARCHAR(11) NOT NULL                           COMMENT '�X�V���[�UID'
  , VERSION               INT(11)     NOT NULL DEFAULT '0'               COMMENT '�o�[�W�����i�y�σ��b�N�p�j'
  , PRIMARY KEY (ID)
);

CREATE TABLE USER_INFO (
  ID                      INT(11)     NOT NULL AUTO_INCREMENT            COMMENT 'ID'
  , EMAIL                 VARCHAR(50)                                    COMMENT '���[���A�h���X'
  , PASSWORD              VARCHAR(100)                                   COMMENT '�p�X���[�h'
  , REGIST_DATE           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '�o�^�N����'
  , REGIST_USER_ID        VARCHAR(11) NOT NULL                           COMMENT '�o�^���[�UID'
  , UPDATE_DATE           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '�X�V�N����'
  , UPDATE_USER_ID        VARCHAR(11) NOT NULL                           COMMENT '�X�V���[�UID'
  , VERSION               INT(11)     NOT NULL DEFAULT '0'               COMMENT '�o�[�W�����i�y�σ��b�N�p�j'
  , PRIMARY KEY (ID)
);
