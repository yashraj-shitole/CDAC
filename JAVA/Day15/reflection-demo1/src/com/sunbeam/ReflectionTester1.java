/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 4, 2024
 */

package com.sunbeam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionTester1 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter class name: ");
		String className = sc.next();
		
		Class c = Class.forName(className);
		System.out.println("Name: " + c.getName());
		
		Class superCls = c.getSuperclass();
		if(superCls != null)
			System.out.println("Super Class: " + superCls.getName());
		
		for(Class intfCls: c.getInterfaces())
			System.out.println("Super Interface: " + intfCls.getName());
		
		Field[] fields = c.getDeclaredFields();
		for(Field f : fields)
			System.out.println("Field: " + f.toString());

		//Method[] methods = c.getMethods(); // returns all methods in the class (including methods inherited from super class)
		Method[] methods = c.getDeclaredMethods(); // returns methods declared in this class only
		for (Method m : methods)
			System.out.println("Method: " + m.toString());
		
		Constructor[] ctors = c.getDeclaredConstructors();
		for (Constructor ct : ctors)
			System.out.println("Ctor : " + ct.toString());
		
		Annotation[] anns = c.getAnnotations();
		for (Annotation an : anns)
			System.out.println("Ann : " + an.toString());

		sc.close();
	}
}
