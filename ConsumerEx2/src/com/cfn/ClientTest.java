package com.cfn;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class ClientTest {

	public static void main(String[] args) {
		Client c= Client.create();
		String url="http://localhost:2017/ProviderEx2/rest/home/header";
		WebResource resource = c.resource(url);
		//Form param client code
		/*Form form= new Form();
		form.add("eid", 123);
		form.add("ename","GHIJ");
		form.add("sal", 89.34);
		
		ClientResponse clientResponse= resource.post(ClientResponse.class, form);*/
		
		//Header Param
		ClientResponse clientResponse=resource.header("eid", 23).header("ename","DFG").post(ClientResponse.class);
		
		
		String s=clientResponse.getEntity(String.class);
		System.out.println(s);

	}

}
