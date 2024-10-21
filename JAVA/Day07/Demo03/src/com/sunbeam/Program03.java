package com.sunbeam;

public class Program03 {

	public static void main(String[] args) {
		Date d = new Date();
		d.setDay(15);
		try {
			d.setMonth(10);
			d.setYear(1800);
			System.out.println("d = " + d);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
