package com.sunbeam.Employee;


//Q2. Create a class called Employee that includes three fields—a first name (type String), a last
//name (type String) and a monthly salary (double). Provide a constructor that initializes the three
//instance variables. Provide a set and a get method for each instance variable. If the monthly salary
//is not positive, do not set its value. Write a test application named EmployeeTest that demonstrates
//class Employee’s capabilities. Create two Employee objects and display each object’s yearly salary.
//Then give each Employee a 10% raise and display each Employee’s yearly salary again.


public class Employee {

	String employeeFirstName;
	String employeeLastName;
	double employeeSalary;
	
	
	public Employee() {
		this("Data not available","Data not available",0); //constructor chaining
	}
	
	public Employee(String employeeFirstName, String employeeLastName, double employeeSalary){
		
		this.employeeFirstName=employeeFirstName;
		this.employeeLastName=employeeLastName;
		
		if (employeeSalary<0) {
			System.err.println("Salary cant be negative");
			this.employeeSalary=0;
		}else {			
			this.employeeSalary=employeeSalary;
		}
	}
	
	
	//getters and setters
	
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public double getYearlyEmployeeSalary() {
		return employeeSalary*12;
	}
	
	
	
	
	
}
