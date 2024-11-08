package com.sunbeam.daos;

import java.sql.Connection;

import com.sunbeam.utils.DBUtil;

public abstract class DAO implements AutoCloseable{ 
	
	protected Connection con;
	
	public DAO() throws Exception {
		con=DBUtil.getConnection();
	}
	

	public void close() throws Exception {
		con.close();			
	}
	
	
}
	