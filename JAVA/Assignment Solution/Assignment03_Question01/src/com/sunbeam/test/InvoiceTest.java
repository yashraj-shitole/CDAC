package com.sunbeam.test;
import java.util.Iterator;

import com.sunbeam.Invoice.*;

public class InvoiceTest {

	public static void main(String[] args) {

//		Invoice i1=new Invoice();
//		Invoice i2=new Invoice();
//		
//		i1.acceptPart();
//		System.out.println("Number \t\tDescription \tQuantity \tPrice \t\tTotal amount");
//		i1.displayPart();
		
		
		//Array of Invoice object
		Invoice[] invoiceArray=new Invoice[3];
		
		for(int i=0;i<invoiceArray.length;i++) {
			//initializing object
			invoiceArray[i]=new Invoice();
			invoiceArray[i].acceptPart();
		}
		
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Number \t\tDescription \tQuantity \tPrice \t\tTotal amount");
		System.out.println("-------------------------------------------------------------------------------");
		for(int i=0;i<invoiceArray.length;i++) {
			
			invoiceArray[i].displayPart();
		}
		System.out.println("-------------------------------------------------------------------------------");
		
	}

}
