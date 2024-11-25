package com.sunbeam.projects;
import java.io.Serializable;
import java.util.Scanner;

public class Project implements Serializable {

	 int id;
	 String title;
	 int teamSize;
	 double projectCost ;
	 String technology;
	 
	 
	 public Project() {
	}
	 public Project(int id) {
		this.id=id;
	}

	public Project(int id, String title, int teamSize, double projectCost, String technology) {
		this.id = id;
		this.title = title;
		this.teamSize = teamSize;
		this.projectCost = projectCost;
		this.technology = technology;
	}
	
	
	public void acceptData(Scanner sc) {
		
		System.out.println("Enter id");
		this.id=sc.nextInt();
		System.out.println("Enter title");
		this.title=sc.nextLine();
		System.out.println("Enter team size");
		this.teamSize=sc.nextInt();
		System.out.println("Enter project cost");
		this.projectCost=sc.nextDouble();
		System.out.println("Enter technology");
		this.technology=sc.next();
		
		
	}
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public double getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(double projectCost) {
		this.projectCost = projectCost;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", teamSize=" + teamSize + ", projectCost=" + projectCost
				+ ", technology=" + technology + "]";
	}

	
	
	
	
	 
	
	
}


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
