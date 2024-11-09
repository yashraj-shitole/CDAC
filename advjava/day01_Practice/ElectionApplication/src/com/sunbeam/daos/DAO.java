package com.sunbeam.daos;

import java.sql.Connection;

import com.sunbeam.utils.DBUtil;

public abstract class DAO implements AutoCloseable{ //autocloseable to close resources automatically in try catch
	
	protected Connection con;
	
	public DAO() throws Exception {
		con=DBUtil.getConnection();
	}
	

	public void close() throws Exception {
		con.close();			
	}
	
	
	

}
