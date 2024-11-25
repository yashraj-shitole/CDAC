package com.sunbeam;

import java.util.Scanner;

public class Date {
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

	public void acceptDate(Scanner sc) {
		System.out.print("Enter day - ");
		day = sc.nextInt();
		System.out.print("Enter month - ");
		month = sc.nextInt();
		System.out.print("Enter year- ");
		year = sc.nextInt();
	}

	public String getDateDetails() {
		return day + "/" + month + "/" + year;
	}

}
