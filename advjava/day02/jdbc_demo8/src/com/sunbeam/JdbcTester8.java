/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 6, 2024
 */

package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JdbcTester8 {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/kdacdb";
	public static final String DB_USER = "kdac";
	public static final String DB_PASSWD = "kdac";
	
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
			String sql = "SELECT * FROM candidates";
			try(PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
				try(ResultSet rs = stmt.executeQuery()) {
					System.out.println("Forward Traversal using ResultSet");
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String party = rs.getString("party");
						int votes = rs.getInt("votes");
						System.out.println(id + ", " + name + ", " + party + ", " + votes);						
					}
					
					System.out.println("\nInsert using ResultSet");
					System.out.print("Enter id: ");
					int id = sc.nextInt();
					System.out.print("Enter name: ");
					String name = sc.next();
					System.out.print("Enter party: ");
					String party = sc.next();
					System.out.print("Enter votes: ");
					int votes = sc.nextInt();
					rs.moveToInsertRow(); // jump to an empty row for new record
					rs.updateInt("id", id); // update that row's column in rs
					rs.updateString("name", name); // update that row's column in rs
					rs.updateString("party", party);// update that row's column in rs
					rs.updateInt("votes", votes); // update that row's column in rs
					rs.insertRow(); // insert that row in db
					System.out.println("Row Inserted...");
					
					System.out.println("\nUpdate using ResultSet");
					System.out.print("Enter row number to be deleted: ");
					int row = sc.nextInt();
					if(rs.absolute(row)) { // jump to given row
						System.out.print("Enter new party: ");
						String newParty = sc.next();
						System.out.print("Enter new votes: ");
						int newVotes = sc.nextInt();
						rs.updateString("party", newParty); // update current row's column in rs
						rs.updateInt("votes", newVotes); // update current row's column in rs
						rs.updateRow(); // update changes of current in db
						System.out.println("Row Updated...");
					}
					else
						System.out.println("Row not exist.");
					
					System.out.println("\nDeletion using ResultSet");
					System.out.print("Enter row number to be deleted: ");
					row = sc.nextInt();
					if(rs.absolute(row)) { // jump to given row
						rs.deleteRow(); // delete current row from rs & db
						System.out.println("Row deleted...");
					}
					else
						System.out.println("Row not exist.");
				} // rs.close();
			} // stmt.close();
		} // con.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
