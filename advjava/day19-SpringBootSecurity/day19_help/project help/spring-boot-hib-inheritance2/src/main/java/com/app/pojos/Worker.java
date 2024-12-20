package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@PrimaryKeyJoinColumn(name = "emp_id")
@Table(name="worker2")
@Getter
@Setter
@ToString
public class Worker extends Employee {
//	@JsonProperty("hours")
	private int noOfHours;
//	@JsonProperty("hrly_rate")
	private double rate;
}
