package com.sunbeam.projects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

//Q1. Maintain a HashSet of projects and perform given operations in a menu-driven program.
//Ensure that projects are not duplicated by the project id in the set.
//Each project information includes int id, String title, int teamSize, double projectCost , String
//technology.
//All the projects should be stored in the file before the program ends and loaded in the
//collection when program starts.
//1. Add Following Projects in the Set
//2. Input a Project from user and add in Set
//3. Display all Projects in Set
//4. Delete a Project by Id from Set
//5. Copy All Projects from Set to ArrayList
//6. Display all Projects from List
//7. Sort all Projects in List by cost
//8. Find project with Max team size using Collections.max()
//9. Count all Projects of "Java" technology using Stream API
//Dummy Data
//- new Project(1, "Train Reservation System", 5000000, "Java")
//- new Project(2, "Airline Reservation System",3, 6000000, ".NET")
//- new Project(4, "Online Grocery Shop", 6, 3000000, "Java")
//- new Project(5, "Online Book Shop", 2, 3000000, ".NET")
//- new Project(3, "Online Jewelry Shop", 4, 4000000, "Java")
//- new Project(2, "Bus Reservation System", 3, 3500000, "JS")



public class ProjectsApp {

	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		
			HashSet<Project> projectHashSet= readData();
		
		
		
		
		ArrayList<Project> projectArrayList=new ArrayList<>();
		
		
		
		
		int choice=1;
		
		while(choice!=0) {
			
			System.out.println("1. Add Following Projects in the Set\n"
					+ "2. Input a Project from user and add in Set\n"
					+ "3. Display all Projects in Set\n"
					+ "4. Delete a Project by Id from Set\n"
					+ "5. Copy All Projects from Set to ArrayList\n"
					+ "6. Display all Projects from List\n"
					+ "7. Sort all Projects in List by cost\n"
					+ "8. Find project with Max team size using Collections.max()\n"
					+ "9. Count all Projects of \"Java\" technology using Stream API");
			
			System.out.print("Enter choice");
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				projectHashSet.add(new Project(1, "Train Reservation System",3, 5000000, "Java"));
				projectHashSet.add(new Project(2, "Airline Reservation System",3, 6000000, ".NET"));
				projectHashSet.add(new Project(4, "Online Grocery Shop", 6, 3000000, "Java"));
				projectHashSet.add(new Project(5, "Online Book Shop", 2, 3000000, ".NET"));
				projectHashSet.add(new Project(3, "Online Jewelry Shop", 4, 4000000, "Java"));
				projectHashSet.add(new Project(2, "Bus Reservation System", 3, 3500000, "JS"));
				
				
				break;
			case 2:
				Project p2=new Project();
					p2.acceptData(sc);
					projectHashSet.add(p2);
				break;
			case 3:
				projectHashSet.forEach(System.out::println);
				break;
			case 4:
				System.out.println("Enter id of project to delete");
				int id=sc.nextInt();
				projectHashSet.remove(new Project(id));
				break;
			case 5:
				projectArrayList.addAll(projectHashSet);
				System.out.println("HasSet converted to ArrayList");
				break;
			case 6:
				projectArrayList.forEach(System.out::println);
				break;
			case 7:
				projectArrayList.stream().sorted((x,y)->Double.compare(x.projectCost, y.projectCost)).forEach(System.out::println);
				break;
			case 8:
				Collections.max(projectArrayList, (x,y)->x.teamSize-y.teamSize);
				projectArrayList.forEach(System.out::print);
				break;
			case 9:
				System.out.println("Count of projects: "+ projectArrayList.stream().filter(project -> "Java".equals(project.getTechnology())).count());
				break;
			}
			
			
		}
		
		
		ProjectsApp.writeData(projectHashSet);

	}

	private static void writeData(HashSet<Project> projectHashSet) {
		try(FileOutputStream fos=new FileOutputStream("projectsDatabase.db")){
			
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(projectHashSet);
			}
			
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	private static HashSet<Project> readData() {

		try (FileInputStream fis=new FileInputStream("projectsDatabase.db")){
			try (ObjectInputStream ois=new ObjectInputStream(fis)){
				
				return (HashSet<Project>) ois.readObject();
				
		
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return new HashSet<>() ;
		
	}

}
