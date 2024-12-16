package com.sunbeam.iplteam.pojos;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString()
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
