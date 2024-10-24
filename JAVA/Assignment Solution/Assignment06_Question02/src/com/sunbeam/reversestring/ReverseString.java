package com.sunbeam.reversestring;

import java.util.Iterator;

public class ReverseString {

	
	private String reversedString="";
	
	public void setString(String inputString) {
		
		for (int i = inputString.length()-1; i >= 0; i--) {
			
			reversedString+=inputString.charAt(i);
		}
		
	}
	
	public String getReversedString() {
		return reversedString;
	}
}
