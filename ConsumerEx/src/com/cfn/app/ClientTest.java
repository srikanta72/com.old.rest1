package com.cfn.app;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientTest {

	public static void main(String[] args) {
		Client c= Client.create();
		String url="http://localhost:2017/ProviderEx/rest/home/home";
		WebResource resource = c.resource(url);
		ClientResponse clientResponse= resource.post(ClientResponse.class);
		String s=clientResponse.getEntity(String.class);
		System.out.println(s);
	}

}
