package com.sunbeam.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entities.User;

public class UserDaoImplementation extends DAO implements UserDao {

	private PreparedStatement statementFindAll;
	private PreparedStatement statementFindById;
	private PreparedStatement statementSaveUser;
	private PreparedStatement statementUpdateUser;
	private PreparedStatement statementDeleteUser;
	private PreparedStatement statementFindByEmail;
	
	
	
	
	public UserDaoImplementation() throws Exception {
		
		//Find all 
		String queryFindAllUsers="Select * from users";
		statementFindAll=con.prepareStatement(queryFindAllUsers);
		
		//Find by id
		String queryFindByIdUser="Select * from users where id= ? ";
		statementFindById=con.prepareStatement(queryFindByIdUser);
		
		//Save user
		String querySaveUser="Insert into users(first_name, last_name, email, password, dob, status,role) values(?,?,?,?,?,?,?)";
		statementSaveUser=con.prepareStatement(querySaveUser);
		
		//Update user
		String queryUpdateUser="Update users set first_name= ?, last_name= ?,email= ?,password=?, dob= ? , status= ? , role= ? where id= ?";
		statementUpdateUser=con.prepareStatement(queryUpdateUser);
		
		//Delete user
		String queryDeleteUser="delete from users where id=?";
		statementDeleteUser=con.prepareStatement(queryDeleteUser);
		
		//Find by email
		String queryFindByEmail="select * from users where email=?";
		statementFindByEmail=con.prepareStatement(queryFindByEmail);
		
		
	}

	@Override
	public void close() throws Exception {

		//to close resources
		statementFindAll.close();
		statementFindById.close();
		statementSaveUser.close();
		statementUpdateUser.close();
		statementDeleteUser.close();
		statementFindByEmail.close();
	}

	
	
	//FIND ALL USERS
	@Override
	public ArrayList<User> findAllUsers() throws Exception {
		ArrayList<User> userList=new ArrayList<>();
		
		try(ResultSet rs= statementFindAll.executeQuery()){
			
			while (rs.next()) {
				
				int id= rs.getInt("id");
				String first_name=rs.getString("first_name");
				String last_name=rs.getString("last_name");
				String email=rs.getString("email");
				String password=rs.getString("password");
				Date date=rs.getDate("dob");
				int status=rs.getInt("status");
				String role=rs.getString("role");
				
				User u=new User(id, first_name, last_name, email, password, date, status, role);
				
				userList.add(u);
				
			}
			
		}
		
		return userList;
	}
	
	

	
	//FIND USER BY ID

	@Override
	public User findUserById(int id) throws Exception {
		
		statementFindById.setInt(1, id);
		
		try(ResultSet rs=statementFindById.executeQuery() ){
			
			if(rs.next()) {
				
				id= rs.getInt("id");
				String first_name=rs.getString("first_name");
				String last_name=rs.getString("last_name");
				String email=rs.getString("email");
				String password=rs.getString("password");
				Date date=rs.getDate("dob");
				int status=rs.getInt("status");
				String role=rs.getString("role");
				
				User u=new User(id, first_name, last_name, email, password, date, status, role);
				 return u;
			}
		}
		
		return null;
	}
	

	//SAVE USER
	@Override
	public int saveUser(User u) throws Exception {
		
		statementSaveUser.setString(1, u.getFirstName());
		statementSaveUser.setString(2, u.getLastName());
		statementSaveUser.setString(3, u.getEmail());
		statementSaveUser.setString(4, u.getPassword());
		statementSaveUser.setDate(5, u.getBirth());
		statementSaveUser.setInt(6, u.getStatus());
		statementSaveUser.setString(7, u.getRole());
		
		int count= statementSaveUser.executeUpdate();
		
		return count;
	}

	//UPDATE USER
	@Override
	public int updateUser(User u) throws Exception {
		
		
		statementUpdateUser.setString(1, u.getFirstName());
		statementUpdateUser.setString(2, u.getLastName());
		statementUpdateUser.setString(3, u.getEmail());
		statementUpdateUser.setString(4, u.getPassword());
		statementUpdateUser.setDate(5, u.getBirth());
		statementUpdateUser.setInt(6, u.getStatus());
		statementUpdateUser.setString(7, u.getRole());
		statementUpdateUser.setInt(8, u.getId());
		
		int count = statementUpdateUser.executeUpdate();
		
		return count;
	}

	
	//DELETE USER
	@Override
	public int deleteUserById(int id) throws Exception {
		
		statementDeleteUser.setInt(1, id);
		int count= statementDeleteUser.executeUpdate();
		
		return count;
	}

	
	//FIND USER BY EMAIL
	@Override
	public User findUserByEmail(String email) throws Exception {
		
		statementFindByEmail.setString(1, email);
		
		try(ResultSet rs=statementFindByEmail.executeQuery()){
			if(rs.next()) {
				
				int id= rs.getInt("id");
				String first_name=rs.getString("first_name");
				String last_name=rs.getString("last_name");
				email=rs.getString("email");
				String password=rs.getString("password");
				Date date=rs.getDate("dob");
				int status=rs.getInt("status");
				String role=rs.getString("role");
				
				User u=new User(id, first_name, last_name, email, password, date, status, role);
				 return u;
				 
			}
		}
		
		return null;
	}

	
}
