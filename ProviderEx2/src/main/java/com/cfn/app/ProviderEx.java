package com.cfn.app;

import java.util.StringTokenizer;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.codec.binary.Base64;

import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;


@Path("/home")
public class ProviderEx {

	/*@GET
	@Path("/query")
	public String show(
			@QueryParam("eid")int id,
			@QueryParam("ename")String nm,
			@QueryParam("sal")double sal){
		return "Hello: Query "+id+","+nm+","+sal;
	}
	
	@GET
	@Path("/matrix")
	public String show2(
			@MatrixParam("eid")int id,
			@MatrixParam("ename")String nm,
			@MatrixParam("sal")double sal){
		return "Hello: Matrix "+id+","+nm+","+sal;
	}
	
	@POST
	@Path("/form")
	public String show3(
			@FormParam("eid")int id,
			@FormParam("ename")String nm,
			@FormParam("sal")double sal){
		return "Hello: Form "+id+","+nm+","+sal;
	}*/
	
	@POST
	@Path("/header")
	public Response show4(
			@HeaderParam("Authorization")String auth){
		String msg= null;
		/**
		 * In case of Basic authentication we have to remove the Basic word 
		 * So that we will get our authentication details.
		 */
		
		auth=auth.replaceFirst("Basic ", "");
		
		
		byte[] encodedBytes=auth.getBytes();
		byte[] decodedBytes=Base64.decodeBase64(encodedBytes);
		String decodedString=new String(decodedBytes);
		
		StringTokenizer tokenizer=new StringTokenizer(decodedString, ":");
		String user=tokenizer.nextToken();
		String pass=tokenizer.nextToken();
		
		ResponseBuilder builder=new ResponseBuilderImpl();
		
		if("admin".equalsIgnoreCase(user) && "sathya".equals(pass)){
			msg="You are valid user";
			builder.status(Status.OK);
//			builder.status(200);
		}
		else{
			msg="U are NOt Valid";
			builder.status(Status.UNAUTHORIZED);
//			builder.status(401);			
		}
		builder.entity(msg);
		Response response= builder.build();
		
		return response;
	}
}
