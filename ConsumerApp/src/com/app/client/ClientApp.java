package com.app.client;

import com.app.util.CodecUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientApp {

	/**
	 * This client App, makes request
	 * to provider using user,pwd as
	 * Header Param which are encoded
	 * along with JSON String given by
	 * Servlet.  
	 * It returns String(response entity)
	 * back to servlet(from where it is called)
	 */
	public static String doConnect(String json){
		String url="http://localhost:2017/ProviderApp/rest/employee/save";
		String resStr="No Message";
		try {
			Client c=Client.create();
			WebResource r=c.resource(url);
			
			ClientResponse cr=r
					.header("user", CodecUtil.doEncode("admin"))
					.header("password", CodecUtil.doEncode("sathya"))
					.type("application/json")
					.post(ClientResponse.class,json);
			resStr=cr.getEntity(String.class);
			System.out.println("Git2");
			System.out.println(" Github used and overriden twice.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resStr;
	}
}
