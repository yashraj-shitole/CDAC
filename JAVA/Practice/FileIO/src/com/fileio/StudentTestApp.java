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
				
				for(Student s1:studentArrayList) {
					s1.getName();
				}
				
				break;
			
			case 3:
				System.out.println("Enter roll number to search");
				
				for(Student s1:studentArrayList) {
					
					if(s1.getRollNo()== sc.nextInt()) {
						System.out.println("Student found");
						s1.getName();
					}
					else {
						System.out.println("Student not found");
					}
				}
				
				break;
			default:
				System.out.println("Wrong choice");
				
				
			}
			
			
		}
		
		
		
		
		
		
		StudentTestApp.writeData(studentArrayList);
	}

	private static void writeData(ArrayList<Student> studentArrayList) {
		
		try(FileOutputStream fos=new FileOutputStream("StudentData.db")){
			
			try(ObjectOutputStream oos=new ObjectOutputStream(fos)){
				
				oos.writeObject(studentArrayList);
				
				
			}
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		
	}

	private static ArrayList<Student> readData() {
		
		try (FileInputStream fis=new FileInputStream("StudentData.db")){
			
			try(ObjectInputStream ois=new ObjectInputStream(fis)){
				
				return (ArrayList<Student>) ois.readObject();	
				
			} catch (ClassNotFoundException e) {
			}
		} catch (IOException e) {
		}
		
		
		return new ArrayList<Student>();
		
	}

}
