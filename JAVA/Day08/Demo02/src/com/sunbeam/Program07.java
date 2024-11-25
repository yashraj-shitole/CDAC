package com.sunbeam;

public class Program07 {

	public static void main(String[] args) {
		String s1 = "sunbeam";
		// s1.concat("Infotech");
		// System.out.println(s1);
		String s2 = new String("sunbeam").intern();

		System.out.println("s1==s2 - " + (s1 == s2));
	}

}
