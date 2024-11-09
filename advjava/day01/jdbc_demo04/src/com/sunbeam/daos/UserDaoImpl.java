/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 5, 2024
 */

package com.sunbeam.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entities.User;

public class UserDaoImpl extends Dao implements UserDao {
	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindById;
	private PreparedStatement stmtFindByEmail;
	private PreparedStatement stmtSave;
	
	public UserDaoImpl() throws Exception {
		String sqlFindAll = "SELECT * FROM users";
		stmtFindAll = con.prepareStatement(sqlFindAll);
		String sqlFindById = "SELECT * FROM users WHERE id=?";
		stmtFindById = con.prepareStatement(sqlFindById);
		String sqlFindByEmail = "SELECT * FROM users WHERE email=?";
		stmtFindByEmail = con.prepareStatement(sqlFindByEmail);
		String sqlSave = "INSERT INTO users (first_name, last_name, email, password, dob, status, role) VALUES(?, ?, ?, ?, ?, ?, ?)";
		stmtSave = con.prepareStatement(sqlSave);
	}
	
	public void close() throws Exception {
		stmtSave.close();
		stmtFindByEmail.close();
		stmtFindById.close();
		stmtFindAll.close();
		super.close();
	}
	
	@Override
	public List<User> findAll() throws Exception {
		List<User> list = new ArrayList<User>();
		try(ResultSet rs = stmtFindAll.executeQuery()) {
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Date birth = rs.getDate("dob");
				int status = rs.getInt("status");
				String role = rs.getString("role");
				User u = new User(id, firstName, lastName, email, password, birth, status, role);
				list.add(u);
			}
		} // rs.close();
		return list;
	}
	
	@Override
	public User findById(int id) throws Exception {
		stmtFindById.setInt(1, id);
		try(ResultSet rs = stmtFindById.executeQuery()) {
			if(rs.next()) {
				id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Date birth = rs.getDate("dob");
				int status = rs.getInt("status");
				String role = rs.getString("role");
				User u = new User(id, firstName, lastName, email, password, birth, status, role);
				return u;
			}
		} // rs.close();
		return null;
	}

	@Override
	public User findByEmail(String email) throws Exception {
		stmtFindByEmail.setString(1, email);
		try(ResultSet rs = stmtFindByEmail.executeQuery()) {
			if(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				email = rs.getString("email");
				String password = rs.getString("password");
				Date birth = rs.getDate("dob");
				int status = rs.getInt("status");
				String role = rs.getString("role");
				User u = new User(id, firstName, lastName, email, password, birth, status, role);
				return u;
			}
		} // rs.close();
		return null;
	}
	
	@Override
	public int save(User u) throws Exception {
		stmtSave.setString(1, u.getFirstName());
		stmtSave.setString(2, u.getLastName());
		stmtSave.setString(3, u.getEmail());
		stmtSave.setString(4, u.getPassword());
		stmtSave.setDate(5, u.getBirth());
		stmtSave.setInt(6, u.getStatus());
		stmtSave.setString(7, u.getRole());
		int count = stmtSave.executeUpdate();
		return count;
	}
}











