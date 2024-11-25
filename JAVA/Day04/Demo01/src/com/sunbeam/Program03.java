package com.sunbeam;

public class Program03 {
	public static void main(String[] args) {
		Student[][] arr = new Student[2][];
		arr[0] = new Student[2];
		arr[1] = new Student[3];

		arr[0][0] = new Student(1, "Anil", 50);
		arr[0][1] = new Student(2, "Mukesh", 55);

		arr[1][0] = new Student(3, "Ramesh", 60);
		arr[1][1] = new Student(4, "Suresh", 65);
		arr[1][2] = new Student(5, "Sham", 70);

		System.out.println("Using for loop ->");
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++)
				arr[i][j].display();

		System.out.println();
		System.out.println("Using for each ->");
		for (Student[] ele : arr)
			for (Student s : ele)
				s.display();

	}

}
