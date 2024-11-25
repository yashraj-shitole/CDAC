 package com.sunbeam.tester;

import java.util.Scanner;

import com.sunbeam.entity.AddString;
import com.sunbeam.exceptions.ExceptionLineTooLong;

public class ExceptionTesting {

	public static void main(String[] args) {

		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter a string");
		
		String data=sc.nextLine();
		
		AddString aString=new AddString();
		
		
		try {
			aString.setString(data);
			
		} catch (ExceptionLineTooLong e) {
			e.printStackTrace();
		}
		
		
		if (aString.getString()!=null) {
			
			System.out.println(aString.getString());
		}
		
		
	}

}
