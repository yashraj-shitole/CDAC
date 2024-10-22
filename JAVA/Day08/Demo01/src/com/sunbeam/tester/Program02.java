package com.sunbeam.tester;

import com.sunbeam.entity.Time;
import com.sunbeam.exceptions.InvalidTimeException;

public class Program02 {

	public static void main(String[] args) {
		Time t = new Time();
		try {
			t.setHr(3);
			t.setMin(80);
			System.out.println(t);
		} catch (InvalidTimeException e) {
			e.printStackTrace();
		}

	}

}
