package com.sunbeam.labexam;

import java.util.*;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		TicketList tl=new TicketList();
		
		OperatorList ol=new OperatorList();
		
		tl.createTicket(new Ticket("Enquiry", "ticket1"));
		tl.createTicket(new Ticket("CashWithdraw", "ticket2"));
		tl.createTicket(new Ticket("CashDeposit", "ticket3"));
		tl.createTicket(new Ticket("LoanSupport", "ticket4"));
		tl.createTicket(new Ticket("Others", "ticket5"));
		tl.createTicket(new Ticket("Enquiry", "ticket6"));
		
		
		int choice;
		while(true) {
			
			System.out.println("0. EXIT\n"
							+ "1. Create ticket\n"
							+ "2. Assign Ticket\n"
							+ "3. place high priority ticket\n"
							+ "4. change status\n"
							+ "5. display pending tickets\n"
							+ "6. display completed tickets\n");
			
			choice=sc.nextInt();
			
			switch (choice) {
			case 0:
				System.out.println("Thanks for using");
				return;
			case 1:
				Ticket t=new Ticket();
				t.acceptData();
				tl.createTicket(t);
				break;
				
			case 2:
				tl.display();
				System.out.println("Enter ticket id to assign ticket");
				int id=sc.nextInt();
				if(tl.giveTicket(id)!=null) {
					ol.add(tl.giveTicket(id));
					System.out.println("Ticket added: "+tl.giveTicket(id));
					tl.delete(tl.giveTicket(id));

				}else {
					System.out.println("Ticket not present");
				}
				ol.display();
				break;
			case 3:
				tl.display();
				System.out.println("Enter ticket id to assign ticket");
				int id2=sc.nextInt();
				if(tl.giveTicket(id2)!=null) {
					ol.addHighPriorityTicket(tl.giveTicket(id2));
					System.out.println("Ticket added: "+tl.giveTicket(id2));
					tl.delete(tl.giveTicket(id2));
				}else {
					System.out.println("Ticket not present");
				}
				ol.display();
				break;
			case 4:
				ol.display();
				System.out.println("Enter ticket id to change status");
				int id3=sc.nextInt();
				ol.changeStatus(id3);
				
				
				break;
			case 5:
					tl.displayPendingTickets();
					
				break;
			case 6:
				ol.displayCompletedTickets();
				break;
			case 7:
				tl.display();
				break;
			case 8:
				ol.display();
				break;
				

			default:
				break;
			}
			
			
			
		}
		
		
	}


}
