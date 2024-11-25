package com.sunbeam;

public class Date {
	int day;
	int month;
	int year;

	public Date() {
		// this statement should be the first statement
		// inside the ctor body
		this(1, 1, 1900); // Ctor chaining

		// if we change the value after initialization
		// it becomes the assignment.
		year = 2000;
	}

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String display() {
		return (day + "/" + month + "/" + year);
	}

}
