package com.sunbeam.daoimplimetation;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sunbeam.daos.DAO;
import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.User;

public class UserDaoImplementation extends DAO implements UserDao {

	
	private PreparedStatement statementFindById;
	private PreparedStatement statementSaveUser;
	private PreparedStatement statementUpdateUser;
	private PreparedStatement statementUpdatePasswrd;
	private PreparedStatement statementDeleteUser;
	private PreparedStatement statementFindByEmail;
	private PreparedStatement statementFindAll;

	
	public UserDaoImplementation() throws Exception {

		
		//Find all 
				String queryFindAllUsers="Select * from users";
				statementFindAll=con.prepareStatement(queryFindAllUsers);
				
				
				
				//Find by id
				String queryFindByIdUser="Select * from users where id= ? ";
				statementFindById=con.prepareStatement(queryFindByIdUser);
				
				//Save user
				String querySaveUser="Insert into users(first_name, last_name, email,mobile,birth,password) values(?,?,?,?,?,?)";
				statementSaveUser=con.prepareStatement(querySaveUser);
				
				//Update user
				String queryUpdateUser="update users set first_name = ? , last_name = ? , email = ?, password = ? , mobile = ?, birth = ? where id = ?";
				statementUpdateUser=con.prepareStatement(queryUpdateUser);
				
				//Update pass
				String queryUpdatePassword="update users set password = ? where id = ?";
				statementUpdatePasswrd = con.prepareStatement(queryUpdatePassword);
				
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
		statementFindById.close();
		statementSaveUser.close();
		statementUpdateUser.close();
		statementUpdatePasswrd.close();
		statementDeleteUser.close();
		statementFindByEmail.close();
		statementFindAll.close();
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
				String mobile=rs.getString("mobile");
				Date birth=rs.getDate("birth");
				User u=new User(id, first_name, last_name, email, password, mobile, birth);
				 return u;
			}
		}
		
		return null;
	}

	@Override
	public int saveUser(User u) throws Exception {
		statementSaveUser.setString(1, u.getFirst_name());
		statementSaveUser.setString(2, u.getLast_name());
		statementSaveUser.setString(3, u.getEmail());
		statementSaveUser.setString(4, u.getMobile());
		statementSaveUser.setDate(5, u.getBirth());
		statementSaveUser.setString(6, u.getPassword());
		
		int count= statementSaveUser.executeUpdate();
		
		return count;
	}

	@Override
	public int updateUser(User u) throws Exception {

		System.out.println(u);
		
		statementUpdateUser.setString(1, u.getFirst_name());
		statementUpdateUser.setString(2, u.getLast_name());
		statementUpdateUser.setString(3, u.getEmail());
		statementUpdateUser.setString(4, u.getPassword());
		statementUpdateUser.setString(5, u.getMobile());
		statementUpdateUser.setDate(6, u.getBirth());
		statementUpdateUser.setInt(7, u.getId());
		
		int count = statementUpdateUser.executeUpdate();
		
		return count;
	}
	
	public int updatePassword(int userid,String password) throws SQLException {
		
			statementUpdatePasswrd.setInt(2, userid);
			statementUpdatePasswrd.setString(1, password);
			int count = statementUpdatePasswrd.executeUpdate();
			
		return count;
	}

	@Override
	public int deleteUserById(int id) throws Exception {

		statementDeleteUser.setInt(1, id);
		int count= statementDeleteUser.executeUpdate();
		
		return count;
	}

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
				String mobile=rs.getString("mobile");
				Date birth=rs.getDate("birth");
				User u=new User(id, first_name, last_name, email, password, mobile, birth);
				 return u;
				 
			}
		}
		
		return null;
	}
	
	
	//FIND ALL USERS
	public ArrayList<User> findAllUsers() throws Exception {
		ArrayList<User> userList=new ArrayList<>();
		
		try(ResultSet rs= statementFindAll.executeQuery()){
			
			while (rs.next()) {
				
				int id= rs.getInt("id");
				String first_name=rs.getString("first_name");
				String last_name=rs.getString("last_name");
				String email=rs.getString("email");
				String password=rs.getString("password");
				String mobile=rs.getString("mobile");
				Date birth=rs.getDate("birth");
				
				User u=new User(id, first_name, last_name, email, password, mobile, birth);
				
				userList.add(u);
				
			}
			
		}
		
		return userList;
	}
	
	
	

}