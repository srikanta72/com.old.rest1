package com.app.service;

import com.app.dao.IEmpDao;
import com.app.dao.impl.EmpDaoImpl;
import com.app.model.EmpData;

public class EmpService {

	public static String processReq(EmpData ob){
		String msg=null;
		//Create Object to POJI-POJO
		IEmpDao dao=new EmpDaoImpl();
		//check obj empId in db
		boolean flag=dao.isEmpIdExistInDb(ob.getEmpId());
		//if true return with exist msg
		if(flag){
			msg="Employee with Id'"+ob.getEmpId()+"' already exist";
		}
		//else save into DB
		else{
			int count=dao.saveEmpDataToDb(ob);
			//if count =1 send success msg
			if(count==1)
				msg="Employee inserted successfully!!";
		}
		//return msg back to provider
		return msg;
	}
}
