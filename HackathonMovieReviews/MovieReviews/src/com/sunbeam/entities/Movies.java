package com.sunbeam.entities;

import java.sql.Date;

public class Movies {
	
	int id;
	String title;
	Date release;
	
	
	
	public Movies() {
		// TODO Auto-generated constructor stub
	}



	public Movies(int id,String title, Date release) {
		this.id=id;
		this.title = title;
		this.release = release;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Date getRelease() {
		return release;
	}



	public void setRelease(Date release) {
		this.release = release;
	}



	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", release=" + release + "]";
	}



	
	
	
	
	
}