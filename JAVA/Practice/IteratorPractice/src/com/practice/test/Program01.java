package com.practice.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.practice.Employees;

public class Program01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Employees> eAL=new ArrayList<>();
		
		for(int i=0;i<10;i++) {
			
			Employees e=new Employees( "Employee"+String.valueOf(i),11000*i);
			eAL.add(e);
		}
		
		
//		Iterator<Employees> itr=eAL.iterator();
//		
//		while (itr.hasNext()) {
//			System.out.println(itr.next().toString());	
//		}
		
		
		System.out.println();
		System.out.println();
		
		for(Employees e:eAL) {
			e.toString();
		}

	}

}
