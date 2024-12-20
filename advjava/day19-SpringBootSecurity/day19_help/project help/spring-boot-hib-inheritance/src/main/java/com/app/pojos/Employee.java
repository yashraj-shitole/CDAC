package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance//(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emp_type")
@Table(name = "employees")
@Getter
@Setter
@ToString
public class Employee extends BaseEntity{
	
	@Column(unique = true,length = 30)
	private String name;
	private double salary;
	
}
