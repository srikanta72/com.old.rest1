package com.app.util;

import org.apache.commons.codec.binary.Base64;

public class CodecUtil {

	/**
	 * This method takes encoded
	 * String and converts to
	 * normal format(redable format
	 */
	public static String doDecode(String encStr){
		byte[] arr=Base64.decodeBase64(encStr.getBytes());
		return new String(arr);
	}
}
