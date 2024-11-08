package com.sunbeam.daoimplimetation;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.sunbeam.daos.DAO;
import com.sunbeam.daos.ShareDao;
import com.sunbeam.entities.Movies;
import com.sunbeam.entities.Reviews;
import com.sunbeam.entities.Shares;

public class ShareDaoImplimentation extends DAO implements ShareDao {

	
	 private PreparedStatement statementFindAllShared;
	 private PreparedStatement statementSaveShare;

	 
	public ShareDaoImplimentation() throws Exception {
		
		//Find all 
		String queryFindAll="select * from reviews a , shares b where a.id = b.review_id and b.user_id  = ?";
		statementFindAllShared=con.prepareStatement(queryFindAll);
		
		
		//Save share
		String querySaveShare="Insert into shares(review_id,user_id) values(?,?)";
		statementSaveShare=con.prepareStatement(querySaveShare);
	}

	
	
	public void close() throws Exception{
		statementFindAllShared.close();
		statementSaveShare.close();
		
	}
	
	
	@Override
	public int shareReview(int reviewid,int userid) throws Exception {
		statementSaveShare.setInt(1, reviewid);
		statementSaveShare.setInt(2, userid);
		
		int count= statementSaveShare.executeUpdate();
		
		return count;
	}

	@Override
	public ArrayList<Reviews> displaySharedReviews(int userid) throws Exception {
		ArrayList<Reviews> sharesList=new ArrayList<>();

statementFindAllShared.setInt(1, userid);
		
		try(ResultSet rs= statementFindAllShared.executeQuery()){
			
				while (rs.next()) {

					int id= rs.getInt("id");
					int movie_id=rs.getInt("movie_id");
					String review=rs.getString("review");
					int rating=rs.getInt("rating");
					int user_id=rs.getInt("user_id");
					Timestamp timestamp=rs.getTimestamp("modified");
					
					
					Reviews r=new Reviews(id,movie_id, review, rating, user_id, timestamp);
					
					sharesList.add(r);
					
				}
				
			}
		
		return sharesList;
	}

}
