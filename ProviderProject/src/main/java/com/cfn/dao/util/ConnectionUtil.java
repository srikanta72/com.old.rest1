package com.cfn.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {

	private static Connection connection;
	static{

	}
	public static Connection getConnection(){
		try {
			if (connection==null){
				connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			}
		} catch (SQLException e) {
			System.out.println("It Seems there is connection error to Database");
			e.printStackTrace();
		}

		return connection;
	}
}
