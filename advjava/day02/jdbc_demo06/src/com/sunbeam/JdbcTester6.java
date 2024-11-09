/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 6, 2024
 */

package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcTester6 {
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

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("From Account Id: ");
		int fromAccId = sc.nextInt();
		System.out.print("To Account Id: ");
		int toAccId = sc.nextInt();
		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
			con.setAutoCommit(false); // start tx
			String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
			try(PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setDouble(1, -amount);
				stmt.setInt(2, fromAccId);
				int count1 = stmt.executeUpdate();
				stmt.setDouble(1, +amount);
				stmt.setInt(2, toAccId);
				int count2 = stmt.executeUpdate();
				if(count1 != 1 || count2 != 1)
					throw new RuntimeException("Transfer Failed.");
				System.out.println("Amount transferred.");
				con.commit(); // commit tx
			}
		} catch (Exception e) {
			con.rollback(); // rollback tx
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}
