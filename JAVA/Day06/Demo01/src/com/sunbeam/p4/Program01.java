package com.sunbeam.p4;

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

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

}

public class Program01 {
	public static void main(String[] args) {
		Date d1 = new Date();
		Date d2 = new Date();

		System.out.println("(d1==d2) - " + (d1 == d2)); // false

	}

	public static void main1(String[] args) {
		Date d1 = new Date();
		Date d2 = d1;

		System.out.println("(d1==d2) - " + (d1 == d2)); // true

	}

}
