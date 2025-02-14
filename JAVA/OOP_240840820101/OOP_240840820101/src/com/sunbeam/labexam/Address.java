package com.sunbeam.labexam;

import java.io.Serializable;
import java.util.*;

public class Address implements Serializable {
	
	
 	private String area;
	private String district;
	private int pin;
	
	
	public Address() {
	}
	
	
	public Address(String area, String district, int pin) {
		super();
		this.area = area;
		this.district = district;
		this.pin = pin;
	}
	
	
	//to accept data
	public void acceptAddress(Scanner sc) {
		System.out.print("Enter area: ");
		area=sc.next();
		System.out.print("Enter district: ");
		district=sc.next();
		System.out.println("Enter pin: ");
		pin=sc.nextInt();
	}
	
	
	
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "\nArea: " + area + ",\nDistrict: " + district + ",\nPin:" + pin;
	}


	
	
	
	
	

}
