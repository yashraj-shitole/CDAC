package com.sunbeam.daoimplimetation;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.sunbeam.daos.DAO;
import com.sunbeam.daos.MoviesDao;
import com.sunbeam.entities.Movies;
import com.sunbeam.entities.Reviews;

public class MovieDaoImplimentation extends DAO implements MoviesDao{
	
	
 private PreparedStatement statementFindAllMovies;
 
 
	public MovieDaoImplimentation() throws Exception {
		//Find all 
				String queryFindAll="Select * from movies";
				statementFindAllMovies=con.prepareStatement(queryFindAll);
	}
	
	public void close() throws Exception{
		statementFindAllMovies.close();
		
	}

	@Override
	public ArrayList<Movies> displayAllMovies() throws Exception {
		ArrayList<Movies> movieList=new ArrayList<>();
		
		try(ResultSet rs= statementFindAllMovies.executeQuery()){
			
				while (rs.next()) {

					
					int id= rs.getInt("id");
					String title=rs.getString("title");
					Date date=rs.getDate("rel_date");
					
					
					
					Movies m=new Movies(id,title, date);
					
					movieList.add(m);
					
				}
				
			}
		
		return movieList;
	}

}