package com.app.validator;

import com.app.util.CodecUtil;

public class AuthValidator {

	public static boolean doValidate(String un,String pwd){
		boolean flag=false;
		//decode ->un,pwd
		String user=CodecUtil.doDecode(un);
		String pass=CodecUtil.doDecode(pwd);
		
		//validate
		if("admin".equals(user) && "sathya".equals(pass)){
			flag=true;
		}
		
		return flag;
	}
}
