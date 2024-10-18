package com.sunbeam.p2;

import java.util.Scanner;

public class Program01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee e1 = new Employee();
		e1.accept(sc);
		e1.display();
	}

}
