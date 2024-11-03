package com.sunbeam;

import java.util.*;

public class Customer {

	private int customer_id;
	private String customer_name;
	private String cutomer_email;
	private String password;
	
	private ArrayList<Product> customerProdutList=new ArrayList<>();
	
	
	private double bill=0;
	
	
	
	public Customer() {
		
	}
	
	public Customer(int id) {
		this.customer_id=id;
	}
	
	public Customer(int customer_id, String customer_name, String cutomer_email, String password) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.cutomer_email = cutomer_email;
		this.password = password;
	}
	
	
	public void acceptCustomer(Scanner sc) {
		
		System.out.print("Enter customer id: ");
		customer_id=sc.nextInt();
		System.out.print("Enter customer name: ");
		customer_name=sc.next();
		System.out.print("Enter cutomer email: ");
		cutomer_email=sc.next();
		System.out.print("Enter customer password: ");
		password=sc.next();
		
	}
	
	
	public double getBill() {
		
		for(int i=0;i<customerProdutList.size();i++) {
			
			bill=bill+customerProdutList.get(i).getPrice();
			
		}
		return bill;
		
	}
		
	
	
	public void setBill(double bill) {
		this.bill = bill;
	}

	public ArrayList<Product> getProductList() {
		return customerProdutList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.customerProdutList = productList;
	}




	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCutomer_email() {
		return cutomer_email;
	}
	public void setCutomer_email(String cutomer_email) {
		this.cutomer_email = cutomer_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", cutomer_email="
				+ cutomer_email + ", password=" + password + ", customerProductList=" + customerProdutList + "]";
	}
	
	
	
	
	
	
	
	
	
}
