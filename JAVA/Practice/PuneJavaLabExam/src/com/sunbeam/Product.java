package com.sunbeam;

public class Product {

	private int product_id;
	private String product_name;
	private String purchase_date;
	private double price;
	public Product(int product_id, String product_name, String purchase_date, double price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.purchase_date = purchase_date;
		this.price = price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", purchase_date="
				+ purchase_date + ", price=" + price + "]";
	}

	
	
	
	
	
}
