package com.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/test")
public class Provider {
	@Path("/best")
	@GET
	public String getMsg(@QueryParam("sid")int id,
			@QueryParam("sname")String sn,
			@QueryParam("sfee")double fee){
		return "welcome"+id+","+sn+","+fee;
	}
}