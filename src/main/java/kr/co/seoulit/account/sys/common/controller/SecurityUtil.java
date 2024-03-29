package kr.co.seoulit.account.sys.common.controller;

import java.security.MessageDigest;

public class SecurityUtil {

	public static String encrypt(String tmpStr) throws Exception {

//SHA-512 적용
//단방향 -> 복호화가 안됨... 무슨말이냐,, 보안성 우수해 양자컴퓨터 나오기 전까지 ㅋㅋㅋㅋㅋㅋ 
		MessageDigest md = MessageDigest.getInstance("SHA-512");

		md.update(tmpStr.getBytes());

		byte[] msgb = md.digest();

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < msgb.length; i++) {

			byte temp = msgb[i];

			String str = Integer.toHexString(temp & 0xFF);

			while (str.length() < 2) {

				str = "0" + str;

			}

			str = str.substring(str.length() - 2);

			sb.append(str);

		}

//--

		return sb.toString();

	}

}