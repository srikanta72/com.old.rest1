package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	/**
	 * This method is used to take
	 * an object as a input and
	 * returns String type 
	 * which indicates JSON String
	 * Return Type is JSON Format
	 * 
	 */
	public static String convertObjToJson(Object ob){
		String json=null;
		ObjectMapper om=null;
		try {
			 om  = new ObjectMapper();
			json = om.writeValueAsString(ob);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			om = null;
		}
		return json;
	}
}
