package com.sunbeam;

import java.util.*;

public class Customer {

	private int customer_id;
	private String customer_name;
	private String cutomer_email;
	private String password;
	
	private ArrayList<Product> productList=new ArrayList<>();
	
	
	
	
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
		customer_name=sc.nextLine();
		System.out.print("Enter cutomer email: ");
		cutomer_email=sc.next();
		System.out.print("Enter customer password: ");
		password=sc.next();
		
	}
	
	
	
	
	public ArrayList<Product> getProductList() {
		return productList;
	}




	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
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
				+ cutomer_email + ", password=" + password + ", productList=" + productList + "]";
	}
	
	
	
	
	
	
	
	
	
}
