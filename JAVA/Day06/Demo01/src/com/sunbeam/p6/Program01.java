package com.sunbeam.p6;

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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}

}

public class Program01 {
	public static void main(String[] args) {
		Date d1 = new Date(1, 1, 2000);
		// Date d2 = d1;
		Date d2 = new Date(1, 1, 2000);

		System.out.println("(d1==d2) - " + (d1 == d2)); // false
		System.out.println("(d1.equals(d2)) - " + (d1.equals(d2))); // true

	}

}
