package LinkedList;

import java.util.Scanner;

public class DoublyLinkedList {
	
	class Node{
		Node prev,next;
		Student student;
		
		public Node(Student s) {
			student=s;
		}
	}
	Node head=null,tail=null;
	int size=0;
	
	
	
	
	public void addFirst(Student s) {
		
		if(head==null) {
			head=new Node(s);
			tail=head;
		}
		else {
			Node newNode=new Node(s);
			newNode.next=head;
			newNode.prev=tail;
			head=newNode;
		}	
	}
	
	
	public void display() {
		
		Node trav=tail;
		
		while(trav!=head) {
			System.out.println(trav.student);
			trav=trav.prev;
		}
	}
	
	

}
















class Student{
	
	int roll;
	String name;
	double marks;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(int roll, String name, double marks) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}
	
	
	public void acceptData() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter roll");
		this.roll=sc.nextInt();
		System.out.println("Enter name");
		this.name=sc.next();
		System.out.println("Enter makrs;");
		this.marks=sc.nextDouble();
	}
	
	
	public void displayData() {
		System.out.print("Roll: "+roll);
		System.out.print("Name: "+name);
		System.out.print("Marks: "+marks);
	}


	public int getRoll() {
		return roll;
	}


	public void setRoll(int roll) {
		this.roll = roll;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getMarks() {
		return marks;
	}


	public void setMarks(double marks) {
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	
	
	
	
}