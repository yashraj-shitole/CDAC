package com.sunbeam.entity;

import com.sunbeam.exceptions.ExceptionLineTooLong;

public class AddString {


	private String data;
	
	
	public void setString(String data) throws ExceptionLineTooLong {
		
		if (data.length()>80) {
			throw new ExceptionLineTooLong();
		}
		else {
			this.data=data;
		}
	}
	
	public String getString() {
		return data;
	}
}
