package com.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class StudentTestApp {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		ArrayList<Student> studentArrayList=StudentTestApp.readData();
		if(studentArrayList==null) {			
			studentArrayList=new ArrayList<>();
		}
		else {
		}
		
		
		for (Student student : studentArrayList) {
			System.out.println(student.toString());
		}
		int choice=1;
		
		while(choice!=0) {
			
			System.out.println(   "0. EXIT\n"
								+ "1. Add student\n"
								+ "2. Display students\n"
								+ "3. Search student with name\n"
								+ "4. Edit Math marks of student\n"
								+ "5. Edit English marks of student\n"
								+ "6. Edit Sciecne marks of student\n"
								+ "7. Edit Student Name");
			
			System.out.print("Enter your choice: ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 0:
				System.out.println("Thanks for using app...");
				break;
			case 1:
				Student s=new Student();
						s.acceptData(sc);
						studentArrayList.add(s);
				break;
			
			case 2:
				
				studentArrayList.forEach(System.out::println);

				
				break;
			
			case 3:
				System.out.println("Enter roll number to search");
				int roll=sc.nextInt();
				
				 
				
				break;
			default:
				System.out.println("Wrong choice");
				
				
			}
			
			
		}
		
		
		
		StudentTestApp.writeData(studentArrayList);
	}
	

	private static ArrayList<Student> readData() {

		try {
			FileInputStream fis=new FileInputStream("students.db");
			
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			return (ArrayList<Student>) ois.readObject();
			
			
		} catch (IOException | ClassNotFoundException e) {
		}
		
		return null;
	}


	private static void writeData(ArrayList<Student> studentArrayList){
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("students.db");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(studentArrayList);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	

}
