package com.sunbeam.labexam;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Person implements Serializable {
	
	 private String name;
	 private Date birthDate;
	 private Address homeAddr;
	 
	 
	 public Person() {
		 
	 }
	 
	 
	 
	public Person(String name, Date birthDate, Address homeAddr) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.homeAddr = homeAddr;
	}
	
	
	
	//to accept data
	public void acceptData(Scanner sc) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter person name: ");
		sc.nextLine();
		name=sc.nextLine();
		
		try {
		System.out.print("Enter person birthdate in dd/mm/yy format: ");
			Date birthDate=dateFormat.parse(sc.next());
			this.birthDate=birthDate;
		} catch (ParseException e) {
			System.out.println("wrong date entered...");
		}
		
		Address a=new Address();
		a.acceptAddress(sc);
		homeAddr=a;
		
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Address getHomeAddr() {
		return homeAddr;
	}
	public void setHomeAddr(Address homeAddr) {
		this.homeAddr = homeAddr;
	}
	@Override
	public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println();
		return "Name: " + name + ",\nBirthdate: " + dateFormat.format(birthDate)+ ",\nAddress- " + homeAddr;
		
	}
	 
	 
	 
	 
	 
	 

}
