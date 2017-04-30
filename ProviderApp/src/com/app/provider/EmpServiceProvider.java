package com.app.provider;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.app.model.EmpData;
import com.app.service.EmpService;
import com.app.validator.AuthValidator;

@Path("/employee")
public class EmpServiceProvider {
	@POST
	@Path("/save")
	@Consumes("application/json")
	public String saveData(
			@HeaderParam("user")String user,			
			@HeaderParam("password")String pwd,
			EmpData obj){
		String msg=null;
		//do user,pwd validation
		boolean flag=AuthValidator.doValidate(user, pwd);
		//if true call service layer
		if(flag){
			msg=EmpService.processReq(obj);
		}else{
			//else return with fail msg
			msg="User is invalid";
		}

		return msg;
	}
}
