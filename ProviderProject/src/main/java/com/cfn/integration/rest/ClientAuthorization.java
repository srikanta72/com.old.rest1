package com.cfn.integration.rest;

import java.util.StringTokenizer;

import com.cfn.service.util.CodecUtil;

public class ClientAuthorization {

	public static boolean validateClient(String auth) {
		String credential = auth.replaceFirst("Basic ", "");
		credential = CodecUtil.decode(credential);

		StringTokenizer tokenizer = new StringTokenizer(credential, ":");
		String username = tokenizer.nextToken();
		String password = tokenizer.nextToken();

		if ((username.equalsIgnoreCase("srikanta")) && (password.equals("admin"))) {
			return true;
		} else {
			return false;
		}
	}
}
