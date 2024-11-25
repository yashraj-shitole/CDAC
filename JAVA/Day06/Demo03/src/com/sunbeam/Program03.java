package com.sunbeam;

import java.time.LocalDate;

public class Program03 {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.now();
		System.out.println("d1 = " + d1);

		LocalDate d2 = LocalDate.of(2024, 10, 19);
		System.out.println("d2 = " + d2);

	}

}
