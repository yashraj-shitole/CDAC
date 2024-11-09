
package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTester2 {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/javajdbc";
	public static final String DB_USER = "KD1-Yashraj-86633";
	public static final String DB_PASSWD = "yashraj123";
	
	static {
		// load and register driver
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create jdbc connection
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD)) {
			// create statement
			try(Statement stmt = con.createStatement()) {
				System.out.print("Enter min votes: ");
				String minVotes = sc.nextLine();
				String sql = "SELECT * FROM candidates WHERE votes > " + minVotes;
				System.out.println("SQL: " + sql);
				try(ResultSet rs = stmt.executeQuery(sql)) {
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String party = rs.getString("party");
						int votes = rs.getInt("votes");
						System.out.println(id + ", " + name + ", " + party + ", " + votes);						
					}
				} // rs.close();
			} // stmt.close();
		} // con.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
