package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
//Optional BUT reco anno. , to specify name of PK n FK 
//which references the PK of the emps table
@PrimaryKeyJoinColumn(name = "emp_id")
@Table(name="manager2")
@Getter
@Setter
@ToString
public class Manager extends Employee {
	private double bonus;
	@Column(length = 30)
	private String deptName;
		
}
