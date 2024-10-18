package com.sunbeam.p1;

import java.util.Scanner;

public class Program01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person p = new Person();
		p.acceptPerson(sc);
		p.displayPerson();
	}

}
