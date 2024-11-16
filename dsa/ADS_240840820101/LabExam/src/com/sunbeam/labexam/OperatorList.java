package com.sunbeam.labexam;

import com.sunbeam.labexam.TicketList.Node;

public class OperatorList {

	
	class Node{
		
		Node next;
		Ticket ticket;
		
		public Node(Ticket t) {
			this.ticket=t;
		}
	}
	
	
	Node head;
	
	
	public void add(Ticket t) {
		Node newNode=new Node(t);
		t.setStatus("assigned");
		
		if(head==null) {
			head=newNode;
			newNode.next=head;
			
		}
		
		else if(head.next==null) {
			head.next=newNode;
			newNode.next=head;
		}
		else {
			Node trav=head;
			do {
				trav=trav.next;
			}while(trav.next!=head); 
			
			newNode.next=head;
			trav.next=newNode;
			
			
		}
	}
		
	public void addHighPriorityTicket(Ticket t) {
		Node newNode=new Node(t);

		if(head==null) {
			head=newNode;
			newNode.next=head;
			
		}
		t.setStatus("assigned");
		Node trav=head;
		
		do {
			trav=trav.next;
		}while(trav.next!=head); 
		
		newNode.next=head;
		trav.next=newNode;
		head=newNode;
	}
	
	
	
	
	public Ticket giveTicket(int id) {
		Ticket t = null;
		Node trav=head;
		do {
			if(trav.ticket.getId()==id) {
				t=trav.ticket;
				break;
			}
			trav=trav.next;
		}while(trav!=head ); 
		
		return t;
	}
	
	
	public void changeStatus(int id) {
		
		Node trav=head;
		do {
			if(trav.ticket.getId()==id) {
				trav.ticket.setStatus("completed");
				break;
			}
			trav=trav.next;
		}while(trav!=head ); 
		
		
	}
	
	
	public void displayCompletedTickets() {
		if(head==null) {
			System.out.println("No completed tickets");
			return;
		}
		Node trav=head;
		do {
			if(trav.ticket.getStatus()=="completed")
				System.out.println(trav.ticket);
			trav=trav.next;
		}while(trav!=head ); 
		
	}
	
	public void displayPendingTickets() {
		if(head==null) {
			System.out.println("No pending tickets");

			return;
		}
		Node trav=head;
		do {
			if(trav.ticket.getStatus()=="pending")
				System.out.println(trav.ticket);
			trav=trav.next;
		}while(trav!=head ); 
		
	}
	
	
	public void display() {
		if(head==null) {
			System.out.println("No tickets");

			return;
		}
		Node trav=head;
		do {
			System.out.println(trav.ticket);
			trav=trav.next;
		}while(trav!=head ); 
		
	}


}
