package com.sunbeam.labexam;

import java.awt.Choice;
import java.util.*;

public class Ticket {

	
	int id;
	String type;
	String description;
	String status;
	
	
	static int idIncrement;
	
	{
		id=idIncrement;
		idIncrement++;
	}
	
	public Ticket() {
		
	}

	public Ticket(String type, String description) {
		this.type = type;
		this.description = description;
		this.status = "pending";
	}
	
	
	
	public void acceptData() {
		
		Scanner sc=new Scanner(System.in);
		
		this.status="pending";
		System.out.println("Choose ticket type:\n"
				+ "1. Enquiry\n"
				+ "2. CashWithdraw\n"
				+ "3. CashDeposit\n"
				+ "4. LoanSupport\n"
				+ "5. Others\n"
				+ "Enter your choice: ");
		
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			this.type="Enquiry";
			break;
		case 2:
			this.type="CashWithdraw";
			break;
		case 3:
			this.type="CashDeposit";
			break;
		case 4:
			this.type="LoanSupport";
			break;
		case 5:
			this.type="Others";
			break;

		default:
			System.out.println("Wrong choice");
			break;
		}
		
		System.out.println("Enter description");
		sc.nextLine();
		this.description=sc.nextLine();
		
	}
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static int getIdIncrement() {
		return idIncrement;
	}

	public static void setIdIncrement(int idIncrement) {
		Ticket.idIncrement = idIncrement;
	}



	@Override
	public String toString() {
		return "Ticket [id=" + id + ", type=" + type + ", description=" + description + ", status=" + status + "]";
	}

	

	
	
	
	
	
}
