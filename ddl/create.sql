CREATE DATABASE test01 CHARACTER SET = UTF8;

CREATE USER test01_user IDENTIFIED BY 'test01_user!';

GRANT ALL ON test01.* TO test01_user;

CREATE TABLE test01.ADDRESS (
  ID                      INT(11)     NOT NULL AUTO_INCREMENT            COMMENT 'ID'
  , BELONG_USER_EMAIL     VARCHAR(50) NOT NULL                           COMMENT '�������[�U���[���A�h���X'
  , LASTNAME_KANA         VARCHAR(50)                                    COMMENT '���J�i'
  , FIRSTNAME_KANA        VARCHAR(50)                                    COMMENT '���J�i'
  , LASTNAME              VARCHAR(50)                                    COMMENT '��'
  , FIRSTNAME             VARCHAR(50)                                    COMMENT '��'
  , HOME_PHONE_NUMBER     VARCHAR(15)                                    COMMENT '�d�b�ԍ�'
  , MOBILE_PHONE_NUMBER   VARCHAR(15)                                    COMMENT '�g�ѓd�b�ԍ�'
  , EMAIL                 VARCHAR(50)                                    COMMENT '���[���A�h���X'
  , ZIP_CODE              VARCHAR(8)                                     COMMENT '�X�֔ԍ�'
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

CREATE TABLE test01.USER_INFO (
  ID                      INT(11)      NOT NULL AUTO_INCREMENT            COMMENT 'ID'
  , EMAIL                 VARCHAR(50)  NOT NULL                           COMMENT '���[���A�h���X'
  , PASSWORD              VARCHAR(100) NOT NULL                           COMMENT '�p�X���[�h'
  , REGIST_DATE           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '�o�^�N����'
  , REGIST_USER_ID        VARCHAR(11)  NOT NULL                           COMMENT '�o�^���[�UID'
  , UPDATE_DATE           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '�X�V�N����'
  , UPDATE_USER_ID        VARCHAR(11)  NOT NULL                           COMMENT '�X�V���[�UID'
  , VERSION               INT(11)      NOT NULL DEFAULT '0'               COMMENT '�o�[�W�����i�y�σ��b�N�p�j'
  , PRIMARY KEY (ID)
  , UNIQUE(EMAIL)
);

CREATE TABLE test01.TEMP_USER_INFO (
  ID                      INT(11)      NOT NULL AUTO_INCREMENT            COMMENT 'ID'
  , AUTH_KEY              VARCHAR(150) NOT NULL                           COMMENT '�F�؃L�['
  , EMAIL                 VARCHAR(50)  NOT NULL                           COMMENT '���[���A�h���X'
  , PASSWORD              VARCHAR(100) NOT NULL                           COMMENT '�p�X���[�h'
  , REGIST_DATE           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '�o�^�N����'
  , REGIST_USER_ID        VARCHAR(11)  NOT NULL                           COMMENT '�o�^���[�UID'
  , UPDATE_DATE           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '�X�V�N����'
  , UPDATE_USER_ID        VARCHAR(11)  NOT NULL                           COMMENT '�X�V���[�UID'
  , VERSION               INT(11)      NOT NULL DEFAULT '0'               COMMENT '�o�[�W�����i�y�σ��b�N�p�j'
  , PRIMARY KEY (ID)
  , UNIQUE(AUTH_KEY)
);

