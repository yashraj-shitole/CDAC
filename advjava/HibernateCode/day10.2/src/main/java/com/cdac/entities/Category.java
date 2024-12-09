package com.cdac.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Category extends BaseEntity {
	@Column(length = 50,unique = true)
	private String name;
	private String description;
	//Category 1---->* BlogPost
	/*
	 * mappedBy = appers in inverse side of the association
	 * mandatory- onlu in bidirectional association
	 * value- name of association prop as it appears in the owning side of association
	 * */
	@OneToMany (mappedBy="blogPostCategory")//mandatory , o.w causes - MappingException
	private List<BlogPost> posts=new ArrayList<>();
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}	
}
