package com.app.util;

import org.apache.commons.codec.binary.Base64;

public class CodecUtil {

	/***
	 * This method is used to
	 * Convert Normal String(Readable)
	 * into unreadable format/Encoded
	 * format. 
	 **/
	public static String doEncode(String str){
		String encStr=null;
		try {
			byte[] arr=Base64.encodeBase64(str.getBytes());
			encStr=new String(arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return encStr;
	}
}
