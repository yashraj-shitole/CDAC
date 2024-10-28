package com.sunbeam.p2;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	int empid;
	String name;
	double salary;
	// transient String companyName = "Sunbeam";
	static String companyName = "Sunbeam";

	public Employee() {
	}

	public Employee(int empid, String name, double salary) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + ", companyName=" + companyName
				+ "]";
	}

}
