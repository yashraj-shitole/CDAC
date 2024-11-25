/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 5, 2024
 */

package com.sunbeam.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entities.Candidate;

public class CandidateDaoImpl extends Dao implements CandidateDao {
	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindById;
	private PreparedStatement stmtSave;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtDeleteById;
	
	public CandidateDaoImpl() throws Exception {
		String sqlFindAll = "SELECT * FROM candidates";
		stmtFindAll = con.prepareStatement(sqlFindAll);
		String sqlFindById = "SELECT * FROM candidates WHERE id = ?";
		stmtFindById = con.prepareStatement(sqlFindById);
		String sqlSave = "INSERT INTO candidates(name, party, votes) VALUES(?, ?, ?)";
		stmtSave = con.prepareStatement(sqlSave);
		String sqlUpdate = "UPDATE candidates SET name=?, party=?, votes=? WHERE id=?";
		stmtUpdate = con.prepareStatement(sqlUpdate);
		String sqlDeleteById = "DELETE FROM candidates WHERE id=?";
		stmtDeleteById = con.prepareStatement(sqlDeleteById);
	}
	public void close() throws Exception {
		stmtDeleteById.close();
		stmtUpdate.close();
		stmtSave.close();
		stmtFindById.close();
		stmtFindAll.close();
		super.close();
	}
	public List<Candidate> findAll() throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();
		try(ResultSet rs = stmtFindAll.executeQuery()) {
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String party = rs.getString("party");
				int votes = rs.getInt("votes");
				Candidate c = new Candidate(id, name, party, votes);
				list.add(c);
			}
		} // rs.close();
		return list;
	}
	
	public Candidate findById(int id) throws Exception {
		stmtFindById.setInt(1, id);
		try(ResultSet rs = stmtFindById.executeQuery()) {
			if(rs.next()) {
				id = rs.getInt("id");
				String name = rs.getString("name");
				String party = rs.getString("party");
				int votes = rs.getInt("votes");
				Candidate c = new Candidate(id, name, party, votes);
				return c;
			}
		} // rs.close();		
		return null;
	}
	
	public int save(Candidate c) throws Exception {
		stmtSave.setString(1, c.getName());
		stmtSave.setString(2, c.getParty());
		stmtSave.setInt(3, c.getVotes());
		int count = stmtSave.executeUpdate();
		return count;
	}
	
	public int update(Candidate c) throws Exception {
		stmtUpdate.setString(1, c.getName());
		stmtUpdate.setString(2, c.getParty());
		stmtUpdate.setInt(3, c.getVotes());
		stmtUpdate.setInt(4, c.getId());
		int count = stmtUpdate.executeUpdate();
		return count;
	}
	
	public int deleteById(int id) throws Exception {
		stmtDeleteById.setInt(1, id);
		int count = stmtDeleteById.executeUpdate();
		return count;
	}
}





