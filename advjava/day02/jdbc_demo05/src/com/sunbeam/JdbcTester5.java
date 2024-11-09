/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 6, 2024
 */

package com.sunbeam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class JdbcTester5 {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/kdacdb";
	public static final String DB_USER = "kdac";
	public static final String DB_PASSWD = "kdac";
	
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		// calling stored procedure with IN params
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD)) {
			String sql = "CALL sp_getpartyvotes(?)";
			try(CallableStatement stmt = con.prepareCall(sql)) {
				System.out.print("Enter party: ");
				String party = sc.next();
				stmt.setString(1, party);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					int votes = rs.getInt(1); // "SUM(votes)"
					System.out.println("Party Total Votes: " + votes);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/

		// calling stored procedure with IN & OUT params
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD)) {
			String sql = "CALL sp_fetchpartyvotes(?, ?)";
			try(CallableStatement stmt = con.prepareCall(sql)) {
				System.out.print("Enter party: ");
				String party = sc.next();
				stmt.setString(1, party); // set value of input param
				stmt.registerOutParameter(2, Types.INTEGER); // register output param
				stmt.executeUpdate();
				int votes = stmt.getInt(2); // get value of output param
				System.out.println("Party Total Votes: " + votes);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
