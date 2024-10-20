package com.sunbeam;

import java.util.Calendar;

public class Program02 {

	public static void main(String[] args) {
		// Calendar c = new GregorianCalendar();
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		System.out.println("day = " + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("month = " + (c.get(Calendar.MONTH) + 1));
		System.out.println("year = " + c.get(Calendar.YEAR));

	}

}
