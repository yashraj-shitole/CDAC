package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/javajdbc";
	public static final String DB_USERNAME = "KD1-Yashraj-86633";
	public static final String DB_PASSWORD = "yashraj123";
	
	
	
	static {
		// load and register driver
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	public static Connection getConnection() throws Exception{
		
		Connection con= DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		return con;
		
	}

}
