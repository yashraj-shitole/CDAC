/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Dec 6, 2024
 */

package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBean {
	private int candId;
	private boolean success;
	private int userId;
	
	public VoteBean() {
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void vote() {
		this.success = false;
		// increment candidate votes
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			int count = candDao.incrVote(this.candId);
			if(count == 1) {
				// find the current user in db
				try(UserDao userDao = new UserDaoImpl()) {
					User user = userDao.findById(this.userId);
					if(user != null) {
						// update current user status as voted
						user.setStatus(1);
						count = userDao.update(user);
						if(count == 1)
							this.success = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
