/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 5, 2024
 */

package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTester1 {
	public static void main(String[] args) throws Exception {
		// load and register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// create jdbc connection
		String dbUrl = "jdbc:mysql://localhost:3306/javajdbc";
		Connection con = DriverManager.getConnection(dbUrl, "KD1-Yashraj-86633", "yashraj123");
		// create statement (empty)
		Statement stmt = con.createStatement();
		// execute sql query and process result
		String sql = "SELECT * FROM candidates";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String party = rs.getString("party");
			int votes = rs.getInt("votes");
			System.out.println(id + ", " + name + ", " + party + ", " + votes);
		}
		rs.close();
		// close stmt and connection
		stmt.close();
		con.close();
	}
}
