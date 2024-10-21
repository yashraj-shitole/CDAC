package com.sunbeam;

public class Program02 {

	public static void main(String[] args) {
		Date d = new Date();
		d.setDay(15);
		try {
			d.setMonth(15);
			System.out.println("d = " + d);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
