package com.sunbeam.testreversedstring;

import java.util.Scanner;

import com.sunbeam.reversestring.ReverseString;

public class TestReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		String inputString=sc.nextLine();
		
		ReverseString rs=new ReverseString();
		
		rs.setString(inputString);
		
		System.out.println(rs.getReversedString());
	}

}
