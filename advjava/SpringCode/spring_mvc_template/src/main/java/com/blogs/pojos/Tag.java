package com.blogs.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;

	public Tag() {
		// TODO Auto-generated constructor stub
	}

	public Tag(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
	@Override
	public String toString() {
		return "Tag [name=" + name + "]";
	}

}
