package com.sunbeam.testpalindrome;

import java.util.Scanner;

import com.sunbeam.palindrome.Palindrome;

public class TestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		String inputString=sc.nextLine();
		
		Palindrome palindrome=new Palindrome();
		
		palindrome.setString(inputString);
		
		System.out.println(palindrome.isPalindrom());
	}

}
