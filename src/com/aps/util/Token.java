package com.aps.util;

import java.util.Date;

import javax.servlet.http.HttpSession;

/**
 * ���ƶ����������������Ƿ񷴸��Ƿ�����
 * @author admin
 *
 */
public class Token {
	public static final String TOKEN = "token";
	
	/**
	 * ��������
	 * @return
	 */
	public static String createToken(HttpSession session){
		String token = new String(new Date().getTime()+"");
		//������д��session
		session.setAttribute(TOKEN, token);
		return token;
	}
}
