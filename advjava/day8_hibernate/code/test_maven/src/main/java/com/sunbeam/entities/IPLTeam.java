package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name="teams")
public class IPLTeam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="team_id")
	private Long teamId;
	
	@Column(length = 100,name = "name")
	private String name;
	
	@Column(length = 10)
	private String abbrevation;
	
	@Column(length = 20,nullable= false)
	private String owner;
	
	@Column(name = "max_player_age")
	private int maxPlayerAge;
	
	@Column(name = "batting_avg")
	private double battingAvg;
	
	@Column(name = "wickets_taken")
	private int wicketsTaken;
	
	
	public IPLTeam() {
		// TODO Auto-generated constructor stub
	}
	
	

	public IPLTeam(String name, String abbrevation, String owner, int maxPlayerAge, double battingAvg,
			int wicketsTaken) {
		super();
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}



	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxPlayerAge() {
		return maxPlayerAge;
	}

	public void setMaxPlayerAge(int maxPlayerAge) {
		this.maxPlayerAge = maxPlayerAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	@Override
	public String toString() {
		return "IPLTeam [teamId=" + teamId + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", maxPlayerAge=" + maxPlayerAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken
				+ "]";
	}
	
	
	
	
	
	

}
