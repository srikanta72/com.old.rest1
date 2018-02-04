package com.cfn.service.util;

import org.apache.tomcat.util.codec.binary.Base64;

public class CodecUtil {

	/*
	 * encode(String) takes a Normal String and returns an encoded String
	 */
	public static String encode(String normalString){
		byte[] encodedBytes=Base64.encodeBase64(normalString.getBytes());
		return new String(encodedBytes);
	}
	
	/*
	 * decode(String) takes a Encoded String and returns respected Decoded String
	 */
	public static String decode(String encoded){
		byte[] decodedBytes=Base64.decodeBase64(encoded.getBytes());
		return new String(decodedBytes);
	}
}
