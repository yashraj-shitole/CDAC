package com.sunbeam;

public class Program01 {

	public static void main(String[] args) {
		Date d = new Date();
		try {
			d.setDay(35);
			System.out.println("d = " + d);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

}
