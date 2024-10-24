package com.practice;

public class Employees {
	
	
	private String name;
	private int id;
	private double salary;
	
	private static int idIncre=1;
	
	{
		id=idIncre;
		idIncre++;
	}
	
	public Employees() {
		name="";
		salary=0;
	}
	public Employees(String name,double salary) {
		this.name=name;
		this.salary=salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public static int getIdIncre() {
		return idIncre;
	}
	public static void setIdIncre(int idIncre) {
		Employees.idIncre = idIncre;
	}
	@Override
	public String toString() {
		return "Employees [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}
	
	
	
	
	

}
