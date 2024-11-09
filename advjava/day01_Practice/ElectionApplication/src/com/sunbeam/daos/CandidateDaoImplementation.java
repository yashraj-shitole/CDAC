package com.sunbeam.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

public class CandidateDaoImplementation extends DAO implements CandidateDao {

	
	private PreparedStatement statementFindAll;
	private PreparedStatement statementFindById;
	private PreparedStatement statementSaveCandidate;
	private PreparedStatement statementUpdateCandidate;
	private PreparedStatement statementDeleteCandidate;
	private PreparedStatement statementCastVote;
	
	
	
	public CandidateDaoImplementation() throws Exception {
	
		//Find all 
		String queryFindAll="Select * from candidates";
		statementFindAll=con.prepareStatement(queryFindAll);
		
		//Find by id
		String queryFindById="Select * from candidates where id= ? ";
		statementFindById=con.prepareStatement(queryFindById);
		
		//Save Candidate
		String querySaveCandidate="Insert into candidates(name, party, votes) values(?,?,?)";
		statementSaveCandidate=con.prepareStatement(querySaveCandidate);
		
		//Update Candidate
		String queryUpdateCandidate="Update candidates set name=?, party=?, votes=? where id=?";
		statementUpdateCandidate=con.prepareStatement(queryUpdateCandidate);
		
		//Delete Candidate
		String queryDeleteCandidate="delete from candidates where id=?";
		statementDeleteCandidate=con.prepareStatement(queryDeleteCandidate);
		
		//Cast vote 
		String queryCastVote="Update candidates set votes=? where id= ? ";
		statementCastVote=con.prepareStatement(queryCastVote);
		
	}

	@Override
	public void close() throws Exception {
		
			//to close resources
			statementFindAll.close();
			statementFindById.close();
			statementSaveCandidate.close();
			statementUpdateCandidate.close();
			statementDeleteCandidate.close();
			statementCastVote.close();
	}
	
	public int castVote(int id) {
		
		Candidate c;
		try {
			c = findCandidateById(id);
			int votes=c.getVotes();
			votes++;			
			statementCastVote.setInt(1, votes);
			statementCastVote.setInt(2, c.getId());
			
			statementCastVote.executeUpdate();
			
			
			return 1;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}

	@Override
	public ArrayList<Candidate> findAllCandidates() throws Exception {
		
		ArrayList<Candidate> candidateList=new ArrayList<>();
		
		try(ResultSet rs= statementFindAll.executeQuery()){
			
			while (rs.next()) {
				
				int id= rs.getInt("id");
				String name=rs.getString("name");
				String party=rs.getString("party");
				int votes=rs.getInt("votes");
				
				Candidate c=new Candidate(id, name, party, votes);
				
				candidateList.add(c);
				
			}
			
		}
		
		return candidateList;
	}

	@Override
	public Candidate findCandidateById(int id) throws Exception {
		statementFindById.setInt(1, id);
		
		try(ResultSet rs= statementFindById.executeQuery()){
			if(rs.next()) {
			id=rs.getInt("id");
			String name=rs.getString("name");
			String party=rs.getString("party");
			int votes=rs.getInt("votes");
			
			Candidate c=new Candidate(id, name, party, votes);
			
			return c;
			
			}
		}
		return null;
		
	}

	@Override
	public int saveCandidate(Candidate c) throws Exception {
		
		statementSaveCandidate.setString(1,c.getName());
		statementSaveCandidate.setString(2, c.getParty());
		statementSaveCandidate.setInt(3, c.getVotes());
		
		int count=statementSaveCandidate.executeUpdate();
		
		
		return count;
	}

	@Override
	public int updateCandidate(Candidate c) throws Exception {
		
		statementUpdateCandidate.setString(1,c.getName());
		statementUpdateCandidate.setString(2, c.getParty());
		statementUpdateCandidate.setInt(3, c.getVotes());
		statementUpdateCandidate.setInt(4,c.getId());
		
		int count=statementUpdateCandidate.executeUpdate();
		
		return count;
		
	}

	@Override
	public int deleteCandidateById(int id) throws Exception {
		
		statementDeleteCandidate.setInt(1, id);
		
		int count= statementDeleteCandidate.executeUpdate();

		return count;
	}

	

}
