/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 6, 2024
 */

package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class MySQLClient {
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
		while(true) {
			try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD)) {
				System.out.print("SQL> ");
				String sql = sc.nextLine();
				if(sql.equals("EXIT;"))
					break;
				try(Statement stmt = con.createStatement()) {
					boolean isResultSet = stmt.execute(sql);
					if(isResultSet) {
						// get rows/columns from resultset and print
						try(ResultSet rs = stmt.getResultSet()) {
							ResultSetMetaData md = rs.getMetaData();
							int colCount = md.getColumnCount();
							while(rs.next()) {
								for(int col=1; col<=colCount; col++)
									System.out.print(rs.getObject(col) + ", ");
								System.out.println();
							}
						}
					}
					else {
						// get update count from stmt and print
						int cnt = stmt.getUpdateCount();
						System.out.println("Rows Affected: " + cnt);
					}
				}
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
