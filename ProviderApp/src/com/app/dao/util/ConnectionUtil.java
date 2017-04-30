package com.app.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	private static Connection con=null;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(){
		return con;
	}
	
	
}
