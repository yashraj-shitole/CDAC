package com.sunbeam;

import java.sql.SQLException;

public class Date {
	int day;
	int month;
	int year;

	public void setDay(int day) {
		if (day < 0 || day > 31)
//			throw new RuntimeException();
			throw new RuntimeException("Day should be between 1 and 31");
		this.day = day;
	}

	public void setMonth(int month) throws Exception {
		if (month < 0 || month > 12)
//			throw new Exception();
			throw new Exception("Month should be between 1 and 12");
		this.month = month;
	}

	public void setYear(int year) throws SQLException {
		if (year < 1900)
			throw new SQLException(new RuntimeException()); // Exception Chaining
		this.year = year;
	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

}
