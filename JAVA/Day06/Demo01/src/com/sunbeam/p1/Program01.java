package com.sunbeam.p1;

class Date {
	int day;
	int month;
	int year;

	public Date() {
	}

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String display() {
		return (day + "/" + month + "/" + year);
	}

}

public class Program01 {
	public static void main(String[] args) {
		Date d1 = new Date();
		Date d2 = new Date(1, 2, 2001);
		System.out.println("d1 = " + d1.display());
		System.out.println("d2 = " + d2.display());
	}

}
