package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entity.User;

public class LoginBean {

	
String email;
String password;
User u;

public LoginBean() {
	// TODO Auto-generated constructor stub
}




public boolean loggedIn() {
	
	try(UserDao userdao=new UserDaoImpl()){
		
		User dbUser=userdao.findByEmail(email);
		if(dbUser != null && dbUser.getPassword().equals(password)) {
			
			u=dbUser;
			
			System.out.println(u.toString());
			
			return true;
			
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return false;
}








public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;

}




public User getU() {
	return u;
}


public void setU(User u) {
	this.u = u;
}




@Override
public String toString() {
	return "LoginBeans [email=" + email + ", password=" + password + "]";
}

public LoginBean(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}


	
	
}
