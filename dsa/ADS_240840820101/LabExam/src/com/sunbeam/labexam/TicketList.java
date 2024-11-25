package com.sunbeam.labexam;

import com.sunbeam.labexam.OperatorList.Node;

public class TicketList {
	
	
	class Node{
		
		Node next;
		Ticket ticket;
		
		public Node(Ticket t) {
			this.ticket=t;
		}
	}
	
	Node head;
	int size;
	
	
	public void createTicket(Ticket t) {
		Node newNode=new Node(t);

		
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
	
	public void addFirst(Ticket t) {
		
		Node newNode=new Node(t);
		Node trav=head;
		
		do {
			trav=trav.next;
		}while(trav.next!=head); 
		
		newNode.next=head;
		trav.next=newNode;
		head=newNode;
	}
	
	//to search t and delete
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
	
	public void delete(Ticket t) {
		
		if(head==null) {
			return;	
		}
		
		Node trav=head;
		do {
			if(trav.next.ticket.id==t.id) {
				t=trav.ticket;
				break;
			}
			trav=trav.next;
		}while(trav!=head );
			
		trav.next=trav.next.next;
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
			return;
		}
		Node trav=head;
		do {
			System.out.println(trav.ticket);
			trav=trav.next;
		}while(trav!=head ); 
		
	}

}
