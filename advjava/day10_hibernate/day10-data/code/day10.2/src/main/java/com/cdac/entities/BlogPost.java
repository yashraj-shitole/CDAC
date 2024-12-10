package com.cdac.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="posts")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class BlogPost extends BaseEntity {
	@Column(length = 50,unique = true)
	private String title;
	@Column(length = 50)
	private String description;
	@Column(length = 500)
	private String contents;
	//BlogPost *--->1 Category
	@ManyToOne//mandatory
	@JoinColumn(name="category_id")
	private Category blogPostCategory;
	public BlogPost(String title, String description, String contents) {
		super();
		this.title = title;
		this.description = description;
		this.contents = contents;
	}
	
}
