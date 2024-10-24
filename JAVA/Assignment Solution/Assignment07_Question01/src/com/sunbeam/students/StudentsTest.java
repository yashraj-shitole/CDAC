package com.sunbeam.students;

import java.util.*;
//Q1. Use Arrays.sort() to sort array of Students using Comparator. Write a menu driven code to
//display students
//1. sorted on their city (asc)
//2. sorted on their on marks (desc)
//3. sorted on their on name (asc)
//4. sorted on the rollno (Hint- Use comparable)
//class Student {
//private int roll;
//private String name;
//private String city;
//private double marks;
//}




//comparators
class StudentCityComparator implements Comparator<Students> {
	@Override
	public int compare(Students o1, Students o2) {
		return o1.getCity().compareTo(o2.getCity());
	}
}

class StudentNameComparator implements Comparator<Students> {
	@Override
	public int compare(Students o1, Students o2) {
		return o1.getName().compareTo(o2.getName());
	}
}



class StudentMarksComparator implements Comparator<Students> {
	@Override
	public int compare(Students o1, Students o2) {
		return  Double.compare(o2.getMarks(), o1.getMarks());
	}
}



public class StudentsTest {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		
		Students[] sArray=new Students[5];
		
		sArray[0]=new Students("Yashraj","Kurundwad",89);
		sArray[1]=new Students("Rajwardhan","Kolhapur",80);
		sArray[2]=new Students("Indrajeet","Ghosarwad",85);
		sArray[3]=new Students("Prathamesh","Kolhapur",88);
		sArray[4]=new Students("Pratik","Kurundwad",89);

		int choice=1;
		
		while (choice !=0) {
			
			System.out.println("0. EXIT\n"
					+ "1. sorted on their city (asc)\n"
					+ "2. sorted on their on marks (desc)\n"
					+ "3. sorted on their on name (asc)\n"
					+ "4. sorted on the rollno");
			choice=sc.nextInt();
			
			switch (choice) {
			case 0:
				System.out.println("Thank you for using app!!");
				break;
			case 1:
				StudentCityComparator cityComparator=new StudentCityComparator();
				Arrays.sort(sArray,cityComparator);
				printArray(sArray);
				break;
				
			case 2:
				StudentMarksComparator marksComparator=new StudentMarksComparator();
				Arrays.sort(sArray,marksComparator);
				printArray(sArray);
				break;
				
			case 3:
				StudentNameComparator nameComparator=new StudentNameComparator();
				Arrays.sort(sArray,nameComparator);
				printArray(sArray);
				break;
			
			case 4:
				Arrays.sort(sArray);
				printArray(sArray);
				break;
				
			default:
				System.out.println("WRONG CHOICE");
				break;
			}
		}
				
	}
	
	
	//print array method
	public static <T> void printArray(T[] t) {
		
		for (T t2 : t) {
			System.out.println(t2);
		}
		
	}
	

}






