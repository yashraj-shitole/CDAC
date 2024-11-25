package com.sunbeam.entity;

import com.sunbeam.exceptions.InvalidDateException;

public class Date {
	int day;
	int month;
	int year;

	public void setDay(int day) {
		if (day < 0 || day > 31)
			throw new InvalidDateException();
		this.day = day;
	}

	public void setMonth(int month) {
		if (month < 0 || month > 12)
			throw new InvalidDateException("Month should be between 1 to 12");
		this.month = month;
	}

	public void setYear(int year) {
		if (year < 1900)
			throw new InvalidDateException("year should be > 1900");
		this.year = year;
	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

}
