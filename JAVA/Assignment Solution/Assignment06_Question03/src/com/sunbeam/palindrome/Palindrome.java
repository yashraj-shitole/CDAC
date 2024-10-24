package com.sunbeam.palindrome;

public class Palindrome {

	private String reversedInputString="";
	
	private boolean isPalindrome=false;
	
	public void setString(String inputString) {
		
		for (int i = inputString.length()-1 ; i >= 0; i--) {
			reversedInputString+=inputString.charAt(i);
		}
		
		if (inputString.equals(reversedInputString)) {
			isPalindrome=true;
		}
	}
	
	public boolean isPalindrom() {
		return isPalindrome;
	}
}
