package com.tuyano.springboot.constant;

public class ApConst {
	/** ログインユーザ情報をセッションに保持するためのキー */
	public static final String SESSION_KEY_USER_INFO = "userInfo";
	
	/** system日付をリクエストに保持するためのキー */
	public static final String REQUEST_KEY_SYSDATE = "request_key_sysdate";
	
	/** 未登録ユーザがDB登録するときに指定する仮のユーザ名 */
	public static final String TEMP_USER_NAME = "system";
}
