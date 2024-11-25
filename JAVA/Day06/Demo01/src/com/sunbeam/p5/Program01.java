package com.sunbeam.p5;

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

	@Override
	public boolean equals(Object obj)// this -> d1, obj->d2
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Date) {
			Date d = (Date) obj;
			return (this.day == d.day && this.month == d.month && this.year == d.year);
		}
		return false;
	}

}

public class Program01 {
	public static void main(String[] args) {
		Date d1 = new Date(1, 1, 2000);
		Date d2 = d1;
		// Date d2 = new Date(1, 1, 2000);

		System.out.println("(d1==d2) - " + (d1 == d2)); // false
		System.out.println("(d1.equals(d2)) - " + (d1.equals(d2))); // true

	}

}
