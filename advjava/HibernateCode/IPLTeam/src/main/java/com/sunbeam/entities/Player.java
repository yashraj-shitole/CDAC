package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name="players")
@NoArgsConstructor //creates constructor with no arguments
@AllArgsConstructor //creates constructor with all arguments
@Getter //creates getters
@Setter //creates setters
@ToString(callSuper=true, exclude = "playerTeam") // creates toString method can use exclude property not to add field in toString
public class Player extends BaseEntity {

	 
		private String name;
		private String lastName;
		private LocalDate dob;
		private double battingAvg;
		private int wicketsTaken;
		@ManyToOne
		@JoinColumn(name="team_id")
		private IPLTeam playerTeam;
		
		
		
	}