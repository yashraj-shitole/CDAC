/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 4, 2024
 */

package com.sunbeam;

import java.lang.annotation.Annotation;

@DevInfo(value = "Nilesh", company = "Sunbeam", designation = "Sr Dev")
//@DevInfo(value = "Rahul", company = "Sunbeam Karad", designation = "Sr Dev")
class MyClass {
	// not allowed to use at constructor
	//@DevInfo(value = "Unknown", company = "Sunbeam Karad")
	public MyClass() {
	}
	
	@DevInfo(value = "Amit", designation = "Architect")
	public void myMethod(@DevInfo("Onkar") int myArg) {
		@DevInfo(value = "Pratik", company = "Sunbeam Karad")
		int myVar = 10;
		// ...
	}
}


class YourClass extends MyClass {
	
}

public class AnnotationTester1 {
	public static void main(String[] args) {
		Annotation[] anns = MyClass.class.getDeclaredAnnotations();
		for(Annotation an : anns) {
			System.out.println("Ann: " + an.toString());
			if(an instanceof DevInfo) {
				DevInfo di = (DevInfo) an;
				System.out.println("Name: " + di.value());
				System.out.println("Designation: " + di.designation());
				System.out.println("Company: " + di.company());
			}
		}
		System.out.println("-------------------------------------");
		anns = YourClass.class.getAnnotations();
		for(Annotation an : anns) {
			System.out.println("YourClass Ann: " + an.toString());
		}
	}
}
