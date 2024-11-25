package com.sunbeam.tester;

import com.sunbeam.entity.Date;
import com.sunbeam.exceptions.InvalidDateException;

public class Program01 {

	public static void main(String[] args) {
		Date d = new Date();
		try {
			d.setDay(15);
			d.setMonth(10);
			d.setYear(2000);
		} catch (InvalidDateException e) {
			e.printStackTrace();
		}
		System.out.println(d);
	}

}
