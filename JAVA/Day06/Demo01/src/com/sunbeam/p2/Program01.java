package com.sunbeam.p2;

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
		return day + "/" + month + "/" + year;
	}
}

public class Program01 {
	public static void main(String[] args) {
		Date d1 = new Date();
		Date d2 = new Date(1, 2, 2001);
//		System.out.println("d1 = " + d1.toString());
//		System.out.println("d2 = " + d2.toString());
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
	}

}
