package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "players")
@Table(name="teams")
public class IPLTeam extends BaseEntity {
	
	
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
	
	 @OneToMany (mappedBy="playerTeam")
	   private List<Player> players=new ArrayList<>();

	
	
	public IPLTeam() {}
	
	public IPLTeam(String owner,String abbrevation) {
		
		this.owner=owner;
		this.abbrevation=abbrevation;
		
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
	

}
